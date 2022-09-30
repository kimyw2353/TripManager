package review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.model.CommentDAO;
import comment.model.CommentVO;
import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;

public class ReviewCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String re_num = req.getParameter("re_num");
		
		if(re_num == null || re_num.trim().isEmpty()) {
			this.setViewPage("review.do");
			this.setRedirect(true);
			return;
		}
		
		int re_num_int = Integer.parseInt(re_num);
		
		ReviewDAO dao=new ReviewDAO();
		
		//리뷰 제목, 내용 가져오기
		ReviewVO reviewCarr = dao.reviewchk(re_num_int);
		int re_readnum = dao.updateReadnum(re_num_int);
		System.out.println(reviewCarr);
		
		CommentDAO cmtDao = new CommentDAO();
		List<CommentVO> cmtArr = cmtDao.commentList(re_num_int);
		
		req.setAttribute("review", reviewCarr);
		req.setAttribute("re_readnum", re_readnum);
		req.setAttribute("cmtArr", cmtArr);
		
		this.setViewPage("/review/reviewCheck.jsp");
		this.setRedirect(false);
	}

}
