package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import user.model.UserVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter({ "/user/*", "/admin/*" })
public class LoginCheckFilter implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter...");
		//���ǿ� ����� loginUser�� �ִ��� üũ�ؼ� ������ return
		// ������ ���� ���ͷ� �ѱ��.
		HttpSession session = ((HttpServletRequest)request).getSession();		
		UserVO user= (UserVO)session.getAttribute("loginUser");
		if(user==null) {
			String msg="�α����ؾ� �̿��� �� �־��";
			String loc=((HttpServletRequest)request).getContextPath()+"/login.do";			
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);			
			RequestDispatcher disp = request.getRequestDispatcher("/common/msg.jsp");
			disp.forward(request, response);			
			return;
		}		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
