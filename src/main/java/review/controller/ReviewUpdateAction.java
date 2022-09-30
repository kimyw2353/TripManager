package review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;

public class ReviewUpdateAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String re_num = req.getParameter("re_num");
		
		if(re_num == null || re_num.trim().isEmpty()) {
			this.setViewPage("/review/review.do");
			this.setRedirect(true);
			return;
		}
		
		int re_num_int = Integer.parseInt(re_num);
		
		ReviewDAO dao=new ReviewDAO();
		
		//리뷰 제목, 내용 가져오기
		ReviewVO updateArr = dao.updateList(re_num_int);
		System.out.println(updateArr);
		 
		req.setAttribute("updateArr", updateArr);
		
		this.setViewPage("/review/reviewUpdate.jsp");
		this.setRedirect(false);
	}
}