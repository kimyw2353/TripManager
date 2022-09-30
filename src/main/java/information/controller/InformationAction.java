package information.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import information.model.InformationDAO;
import information.model.InformationVO;
import location.model.LocationDAO;
import location.model.LocationVO;
import recommend.model.RecommendDAO;
import recommend.model.RecommendVO;

public class InformationAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String num = req.getParameter("num");
		if(num==null||num.trim().isEmpty()) {
			this.setRedirect(true);
			this.setViewPage("index.do");
			return;
		}
		
		LocationDAO locdao=new LocationDAO();
		InformationDAO infordao = new InformationDAO();
		RecommendDAO recdao = new RecommendDAO();
		
		LocationVO locvo = locdao.selectLocationByNum(Integer.parseInt(num));
		InformationVO inforvo = infordao.selectInformaitonByNum(Integer.parseInt(num));
		List<RecommendVO>recvo = recdao.selectRecommendByNum(Integer.parseInt(num));
		
		req.setAttribute("location", locvo);
		req.setAttribute("information", inforvo);
		req.setAttribute("recommend", recvo);
		
		this.setViewPage("/information/infor.jsp");
		this.setRedirect(false);
		
	}

}
