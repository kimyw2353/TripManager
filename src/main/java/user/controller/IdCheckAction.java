package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAO;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String method = req.getMethod();
		if(method.equalsIgnoreCase("get")) {
			req.setAttribute("mode", "get");
			this.setViewPage("/member/idCheck.jsp");
			this.setRedirect(false);
		}else {
			String userid = req.getParameter("userid");
			if(userid==null||userid.trim().isEmpty()) {
				req.setAttribute("msg", "아이디를 입력해야해요");
				req.setAttribute("loc", "javascript:history.back()");
				
				this.setViewPage("/member/msg.jsp");
				this.setRedirect(false);
				return;
			}
			UserDAO dao = new UserDAO();
			boolean isUse = dao.idCheck(userid);
			
			String result =(isUse)?"ok":"fail";
			
			
			req.setAttribute("mode", "post");
			req.setAttribute("result", result);
			req.setAttribute("userid", userid);
			
			this.setViewPage("/member/idCheck.jsp");
			this.setRedirect(false);
		}
			
	}

}
