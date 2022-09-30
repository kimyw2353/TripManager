package user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserVO;
import user.model.UserDAO;

public class EditFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session= req.getSession();
		UserVO u_id = (UserVO)session.getAttribute("loginUser");
		if(u_id == null) {
			this.setViewPage("/index.do");
		    this.setRedirect(true);
		    return;
		}
		
		System.out.println("EditForm ¾ÆÀÌµð"+u_id);
		
		UserDAO dao = new UserDAO();
		UserVO Editarr = dao.EditUser(u_id.getU_id());
		System.out.println(Editarr);
		req.setAttribute("Editarr", Editarr);
		
		this.setViewPage("/member/edit.jsp");
	    this.setRedirect(false);

	}

}
