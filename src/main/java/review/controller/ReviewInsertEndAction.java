package review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import review.model.ReviewDAO;
import review.model.ReviewVO;
import common.controller.AbstractAction;

public class ReviewInsertEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String loc_num =req.getParameter("loc_num");
		String u_id = req.getParameter("u_id");
		String reviewtitle =req.getParameter("reviewtitle");
		String reviewcontent =req.getParameter("reviewcontent");
		
		if(reviewtitle == null || reviewtitle.trim().isEmpty() ||
		   reviewcontent == null || reviewcontent.trim().isEmpty()) {
			this.setViewPage("../review/review.do?loc_num="+Integer.parseInt(loc_num));
			this.setRedirect(true);
			return;
		}
		System.out.println(loc_num);
		int loc_num_int = Integer.parseInt(loc_num);
		ReviewVO vo = new ReviewVO();
		vo.setRe_content(reviewcontent);
		vo.setRe_name(reviewtitle);
		vo.setLoc_num(loc_num_int);
		vo.setU_id(u_id);
		
		ReviewDAO dao = new ReviewDAO();
		
		int n = dao.insertReview(vo);
		String str=(n>0)?"글 등록처리 완료":"글 등록처리 실패";
		String loc=(n>0)?"../review/review.do?loc_num="+loc_num_int:"javascript:history.back()";
		
		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		this.setViewPage("/common/msg.jsp");
		this.setRedirect(false);
	}

}
