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
		//세션에 저장된 loginUser가 있는지 체크해서 없으면 return
		// 있으면 다음 필터로 넘긴다.
		HttpSession session = ((HttpServletRequest)request).getSession();		
		UserVO user= (UserVO)session.getAttribute("loginUser");
		if(user==null) {
			String msg="로그인해야 이용할 수 있어요";
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
