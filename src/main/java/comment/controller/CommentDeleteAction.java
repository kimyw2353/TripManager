package comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import comment.model.CommentDAO;
import common.controller.AbstractAction;

public class CommentDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String re_num = req.getParameter("re_num");
		String u_id = req.getParameter("u_id");
		String com_content = req.getParameter("com_content");
		
		if(re_num == null || u_id == null || 
				re_num.trim().isEmpty() || u_id.trim().isEmpty()) {
			this.setViewPage("../review/reviewCheck.do?re_num="+re_num);
			this.setRedirect(true);
			return;
		}
		CommentDAO dao = new CommentDAO();
		int n = dao.deleteComment(Integer.parseInt(re_num),u_id,com_content);

		this.setViewPage("../review/reviewCheck.do?re_num="+re_num);
		this.setRedirect(true);

	}

}
