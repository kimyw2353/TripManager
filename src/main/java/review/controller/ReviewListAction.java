package review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;

public class ReviewListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ���߿� ��ĥ �� �α����� �̿��� id ��������
		HttpSession ses=req.getSession();
		String u_id =(String) ses.getAttribute("u_id");
		String loc_num = (String) ses.getAttribute("loc_num");
		if(u_id==null||loc_num==null) {
			u_id=req.getParameter("u_id");
			loc_num=req.getParameter("loc_num");
		}
		
		System.out.println("ListLOC"+loc_num);
		
		ReviewDAO dao=new ReviewDAO();
		
		int loc_num_int = Integer.parseInt(loc_num);
		//�Խñ� ��� ��������
		List<ReviewVO> reviewListArr = dao.reviewList(u_id,loc_num_int); // dd ��� request.getParameter()�� ������ id�� �ֱ�
		System.out.println(reviewListArr);
		 
		req.setAttribute("reviewListArr", reviewListArr);
		
		this.setViewPage("/review/reviewList.jsp");
		this.setRedirect(false);
	}

}
