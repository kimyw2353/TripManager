package review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;

public class ReviewUpdateEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String reviewtitle =req.getParameter("reviewtitle");
		String reviewcontent =req.getParameter("reviewcontent");
		String re_num =req.getParameter("re_num");
		String u_id =req.getParameter("u_id");
		String loc_num =req.getParameter("loc_num");
		System.out.println("updateEnd"+loc_num);
		
		if(reviewtitle == null || reviewtitle.trim().isEmpty() ||
		   reviewcontent == null || reviewcontent.trim().isEmpty()) {
			this.setViewPage("../review/review.do");
			this.setRedirect(true);
			return;
		}
		
		ReviewVO vo = new ReviewVO();
		vo.setRe_content(reviewcontent);
		vo.setRe_name(reviewtitle);
		vo.setRe_num(Integer.parseInt(re_num));
		vo.setU_id(u_id);
		vo.setLoc_num(Integer.parseInt(loc_num));
		
		ReviewDAO dao = new ReviewDAO();
		
		int n = dao.updateReview(vo);
		
		HttpSession session=req.getSession();
		session.setAttribute("u_id", vo.getU_id());
		session.setAttribute("loc_num", loc_num);
		
		
		String str=(n>0)?"글 수정처리 완료":"글 수정처리 실패";
		String loc=(n>0)?"../review/reviewList.do":"javascript:history.back()";
		
		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		this.setViewPage("/common/msg.jsp");
		this.setRedirect(false);

	}

}
