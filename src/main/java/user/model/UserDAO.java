package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.model.DAOTripManagerBase;
import jdbc.util.DBUtil;
import review.model.ReviewVO;

public class UserDAO extends DAOTripManagerBase {

	private final String NS = "common.mapper.LoginMapper";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public int LoginUser(String id, String pw) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {

			UserVO n = ses.selectOne(NS + ".loginid", id);
			System.out.println("n:" + n + "id:" + id);
			// int m = ses.selectOne(NS+".loginpw",pw);
			if (n != null) {
				if (n.getU_pwd().equals(pw))
					return 1;// 아이디,비번 일치는 경우
				else
					return -1; // 비번 틀린 경우
			} else {
				return -2;// 아이디 없는 경우
			}
		}
	}

	// 회원정보 수정목록조회
	public UserVO EditUser(String u_id) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			UserVO arr = ses.selectOne(NS + ".EditUser", u_id);
			System.out.println("EditUser실행중" + arr);
			return arr;
		}
	}

	public boolean findId(String userid) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			String idx = ses.selectOne(NS + ".findId", userid);
			if (idx == null) {
				// 아이디가 없으면
				return true;
			} else {
				return false;
			}

		}

	}

	public boolean idCheck(String userid) throws SQLException {
		try {
			con = DBUtil.getCon();
			StringBuilder buf = new StringBuilder("select u_id from users ").append(" where u_id =?");
			String sql = buf.toString();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			boolean b = rs.next();
			// b=>true이면 해당 아이디는 존재한다는 의미
			// false면 해당 아이디는 없음
			return !b;
		} finally {
			close();
		}
	}

	public int insertUser(UserVO vo) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			int n = ses.insert(NS + ".insertUser", vo);
			return n;
		}
	}

	public int updateMember(UserVO user) throws SQLException {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			int n = ses.insert(NS + ".editMember", user);
			return n;
		}
	}

	public List<UserVO> makeList(ResultSet rs) throws SQLException {
		List<UserVO> arr = new ArrayList<>();
		while (rs.next()) {
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			String userid = rs.getString("userid");
			String pwd = rs.getString("pwd");
			String phone = rs.getString("phone");
			String mail = rs.getString("mail");
			String loc = rs.getString("loc");
			UserVO vo = new UserVO(idx, name, userid, pwd, phone, mail, loc);
			arr.add(vo);
		}
		return arr;
	}

	/* 로그인 회원을 체크하는 메소드 */
	public UserVO loginCheck(String u_id, String pwd) throws SQLException, NotMemberException {
		UserVO user = this.selectMemberByUserid(u_id);
		System.out.println("아니 유저는 " + user);
		if (user == null) {
			throw new NotMemberException("아이디가 존재하지 않습니다.");
		}
		if (!pwd.equals(user.getU_pwd())) {
			throw new NotMemberException("비밀번호가 일치하지 않습니다.");
		}
		return user;
	}

	private UserVO selectMemberByUserid(String userid) throws SQLException {
		try {
			System.out.println("selectMemberByUserid()메소드 실행");
			con = DBUtil.getCon();
			String sql = "select * from users where u_id=?";
			System.out.println("sql문 들어오나??" + sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			System.out.println("ps는 " + ps);
			rs = ps.executeQuery();
			List<UserVO> arr = makeList(rs);
			System.out.println("makeList 에 " + arr);
			if (arr != null && arr.size() == 1) {
				UserVO user = arr.get(0);
				System.out.println("유저는?? " + user);
				return user;
			}
			return null;
		} finally {
			close();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}