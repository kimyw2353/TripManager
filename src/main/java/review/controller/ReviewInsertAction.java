package review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.controller.AbstractAction;
import review.model.ReviewDAO;

public class ReviewInsertAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String loc_num =req.getParameter("loc_num");
		String u_id = req.getParameter("u_id");
		int loc_num_int = Integer.parseInt(loc_num);
		req.setAttribute("loc_num", loc_num_int);
		req.setAttribute("u_id", u_id);
		System.out.println(loc_num_int);
		this.setViewPage("/review/reviewInsert.jsp");
		this.setRedirect(false);
	}
}