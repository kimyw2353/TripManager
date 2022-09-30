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
					return 1;// ���̵�,��� ��ġ�� ���
				else
					return -1; // ��� Ʋ�� ���
			} else {
				return -2;// ���̵� ���� ���
			}
		}
	}

	// ȸ������ ���������ȸ
	public UserVO EditUser(String u_id) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			UserVO arr = ses.selectOne(NS + ".EditUser", u_id);
			System.out.println("EditUser������" + arr);
			return arr;
		}
	}

	public boolean findId(String userid) {
		try (SqlSession ses = this.getSessionFactory().openSession(true)) {
			String idx = ses.selectOne(NS + ".findId", userid);
			if (idx == null) {
				// ���̵� ������
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
			// b=>true�̸� �ش� ���̵�� �����Ѵٴ� �ǹ�
			// false�� �ش� ���̵�� ����
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

	/* �α��� ȸ���� üũ�ϴ� �޼ҵ� */
	public UserVO loginCheck(String u_id, String pwd) throws SQLException, NotMemberException {
		UserVO user = this.selectMemberByUserid(u_id);
		System.out.println("�ƴ� ������ " + user);
		if (user == null) {
			throw new NotMemberException("���̵� �������� �ʽ��ϴ�.");
		}
		if (!pwd.equals(user.getU_pwd())) {
			throw new NotMemberException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		return user;
	}

	private UserVO selectMemberByUserid(String userid) throws SQLException {
		try {
			System.out.println("selectMemberByUserid()�޼ҵ� ����");
			con = DBUtil.getCon();
			String sql = "select * from users where u_id=?";
			System.out.println("sql�� ������??" + sql);
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			System.out.println("ps�� " + ps);
			rs = ps.executeQuery();
			List<UserVO> arr = makeList(rs);
			System.out.println("makeList �� " + arr);
			if (arr != null && arr.size() == 1) {
				UserVO user = arr.get(0);
				System.out.println("������?? " + user);
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