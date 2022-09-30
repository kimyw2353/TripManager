package review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.controller.AbstractAction;
import review.model.ReviewDAO;
import review.model.ReviewVO;

public class ReviewAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReviewDAO dao=new ReviewDAO();
		String loc_num = req.getParameter("loc_num");
		/*
		 * if(loc_num == null || loc_num.trim().isEmpty()) {
		 * this.setViewPage("infor.do"); this.setRedirect(true); return; }
		 */
		System.out.println(loc_num);
		//���� ������ ������(cpage)�� �޾ƿ���
		String cpStr = req.getParameter("cpage");
		if(cpStr == null || cpStr.trim().isEmpty()) {
			cpStr="1"; // �⺻�������� ����
		}
		int cpage = Integer.parseInt(cpStr);// ���� ������ ������
		int loc_num_int = Integer.parseInt(loc_num);
		int totalCount = dao.getTotalCount(loc_num_int);
		
		int pageSize = 10; //�� �������� 10���� �Խñ� �����ֱ�
		
		int pageCount = 1;
		
		pageCount=(totalCount - 1)/pageSize + 1;
		System.out.println("1/pageCount"+pageCount);
		if(cpage < 1) {
			cpage = 1;//ù �������� ����
		}
		if(cpage > pageCount) {
			cpage = pageCount;// ������ ������ ����
		}
		//DB���� �ش� �������� ����� �������� ���� ����
		int end = cpage * pageSize;
		int start = end - (pageSize-1);
		
		//�Խñ� ��� ��������
		List<ReviewVO> reviewArr = dao.review(loc_num_int,start, end);
		System.out.println(reviewArr);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("reviewArr", reviewArr);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		
		this.setViewPage("/review/review.jsp");
		this.setRedirect(false);
	}

}
