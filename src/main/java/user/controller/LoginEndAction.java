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
		// 1. ���̵�,���,saveId�Ķ���� �� �ޱ�
		String id = req.getParameter("userid");
		String pw = req.getParameter("pwd");
		String saveId = req.getParameter("saveId");

		// 2. ��ȿ�� üũ => login.do�� redirect
		if (id == null || pw == null || id.trim().isEmpty() || pw.trim().isEmpty()) {
			this.setViewPage("login.do");
			this.setRedirect(true);
			return;
		}
		UserVO vo = new UserVO(id,pw);
		UserDAO dao = new UserDAO();
		
		int n = dao.LoginUser(id, pw);
		
		if(n>0) {
			vo=dao.EditUser(id);//id�� ȸ������ ������
			HttpSession session= req.getSession();
			session.setAttribute("loginUser", vo);
						
			//���̵� ����
			Cookie ck=new Cookie("u_id", vo.getU_id());
			System.out.println(">>>"+vo.getU_id());
			if(saveId!=null) {
				ck.setMaxAge(7*24*60*60);//7�ϰ� ����
			}else {
				ck.setMaxAge(0);//��Ű ����
			}
			ck.setPath("/");
			res.addCookie(ck);
		}//if--------
		
		String str = (n>0)?"�α��� ����":(n>-2)?"��й�ȣ�� Ʋ�Ƚ��ϴ�":"���̵� �����ϴ�";
		String msg = (n>0)?"index.do":"javascript:history.back()";
		
		req.setAttribute("msg", str);
		req.setAttribute("loc", msg);
		this.setViewPage("/login/msg.jsp");
		this.setRedirect(false);
		
	}

}
