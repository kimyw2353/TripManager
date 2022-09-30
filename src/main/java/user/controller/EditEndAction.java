package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class EditEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 입력값 받아오기
		int u_idx = Integer.parseInt(req.getParameter("u_idx"));
		String name = req.getParameter("u_name");
		String userid = req.getParameter("u_id");
		String pwd = req.getParameter("u_pwd");
		String phone = req.getParameter("u_phone");
		String email = req.getParameter("u_mail");
		String loc = req.getParameter("u_loc");
		
		System.out.println(phone+"/"+email+"/"+loc+"/"+pwd);

		// 유효성 체크
		if (pwd == null || phone == null || email == null || loc == null || pwd.trim().isEmpty()
				|| phone.trim().isEmpty() || email.trim().isEmpty() || loc.trim().isEmpty()) {
			this.setViewPage("edit.do");
			this.setRedirect(true);
			return;
		}

		UserVO user = new UserVO(u_idx, name, userid, pwd, phone, email, loc);
		UserDAO dao = new UserDAO();
		System.out.println(user);
		int n = dao.updateMember(user);

		String str = (n > 0) ? "회원정보 수정완료" : "회원정보 수정실패";
		String loca = (n > 0) ? "index.do" : "javascript:history.back()";
		req.setAttribute("msg", str);
		req.setAttribute("loc", loca);

		this.setViewPage("/member/msg.jsp");
		this.setRedirect(false);
	}

}