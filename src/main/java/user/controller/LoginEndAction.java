package user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserVO;
import user.model.UserDAO;

public class LoginEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. 아이디,비번,saveId파라미터 값 받기
		String id = req.getParameter("userid");
		String pw = req.getParameter("pwd");
		String saveId = req.getParameter("saveId");

		// 2. 유효성 체크 => login.do로 redirect
		if (id == null || pw == null || id.trim().isEmpty() || pw.trim().isEmpty()) {
			this.setViewPage("login.do");
			this.setRedirect(true);
			return;
		}
		UserVO vo = new UserVO(id,pw);
		UserDAO dao = new UserDAO();
		
		int n = dao.LoginUser(id, pw);
		
		if(n>0) {
			vo=dao.EditUser(id);//id로 회원정보 가져오
			HttpSession session= req.getSession();
			session.setAttribute("loginUser", vo);
						
			//아이디 저장
			Cookie ck=new Cookie("u_id", vo.getU_id());
			System.out.println(">>>"+vo.getU_id());
			if(saveId!=null) {
				ck.setMaxAge(7*24*60*60);//7일간 보관
			}else {
				ck.setMaxAge(0);//쿠키 삭제
			}
			ck.setPath("/");
			res.addCookie(ck);
		}//if--------
		
		String str = (n>0)?"로그인 성공":(n>-2)?"비밀번호가 틀렸습니다":"아이디가 없습니다";
		String msg = (n>0)?"index.do":"javascript:history.back()";
		
		req.setAttribute("msg", str);
		req.setAttribute("loc", msg);
		this.setViewPage("/login/msg.jsp");
		this.setRedirect(false);
		
	}

}
