package comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comment.model.CommentDAO;
import comment.model.CommentVO;
import common.controller.AbstractAction;

public class CommentWriteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String u_id = req.getParameter("u_id");
		String re_num = req.getParameter("re_num");
		String com_content = req.getParameter("com_content");
		if(re_num == null || re_num.trim().isEmpty()) {
			this.setViewPage("../review/reviewCheck.do?re_num="+re_num);
			this.setRedirect(true);
			return;
		}
		int re_num_int = Integer.parseInt(re_num.trim());
		CommentVO rvo = new CommentVO(re_num_int,u_id,com_content);
		CommentDAO dao = new CommentDAO();
		
		int n = dao.insetComment(rvo);
		System.out.println(n);
		this.setViewPage("../review/reviewCheck.do?re_num="+re_num);
		this.setRedirect(true);
	}
}