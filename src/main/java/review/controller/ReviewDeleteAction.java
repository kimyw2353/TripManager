package review.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;
import user.model.UserVO;

public class ReviewDeleteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String re_num = req.getParameter("re_num");
		String u_id = req.getParameter("u_id");
		String loc_num = req.getParameter("loc_num");
		System.out.println();

		if (re_num == null || re_num.trim().isEmpty()) {
			this.setViewPage("review.do");
			this.setRedirect(true);
			return;
		}

		ReviewVO vo = new ReviewVO();
		ReviewDAO dao = new ReviewDAO();
		int re_num_int = Integer.parseInt(re_num);
		int loc_num_int = Integer.parseInt(loc_num);
		vo.setRe_num(re_num_int);
		vo.setU_id(u_id);
		vo.setLoc_num(loc_num_int);
		HttpSession session=req.getSession();
		session.setAttribute("u_id", vo.getU_id());
		session.setAttribute("loc_num", loc_num);

		int n = dao.deleteReview(vo);
		String str = (n > 0) ? "글 삭제처리 완료" : "글 삭제처리 실패";
		String loc = (n > 0) ? "../review/reviewList.do" : "javascript:history.back()";

		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		this.setViewPage("/common/msg.jsp");
		this.setRedirect(false);
	}

}
