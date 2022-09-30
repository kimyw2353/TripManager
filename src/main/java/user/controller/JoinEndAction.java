package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class JoinEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String mail = req.getParameter("email");
		String loc = req.getParameter("loc");
		
		if(name==null||userid==null||pwd==null||
		name.trim().isEmpty()||userid.trim().isEmpty()||pwd.trim().isEmpty()) {
		this.setViewPage("join.do");
		this.setRedirect(true);
		return;
	}
	UserVO user=new UserVO(0,name,userid,pwd,phone,mail,loc);
	UserDAO dao = new UserDAO();
	int n = dao.insertUser(user);
	
	String str= (n>0)?"회원가입 처리 완료":"회원가입 실패";
	String loc2 =(n>0)?" index.do":"javascript:history.back()";
	
	req.setAttribute("msg",str);
	req.setAttribute("loc",loc2);
	
	this.setViewPage("/member/msg.jsp");
	this.setRedirect(false);
	}
}
