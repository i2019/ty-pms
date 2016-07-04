package ty.pms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	 @Override
	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	        //获得在下面代码中要用的request,response,session对象
	        HttpServletRequest servletRequest = (HttpServletRequest) request;
	        HttpServletResponse servletResponse = (HttpServletResponse) response;
	        HttpSession session = servletRequest.getSession();

	        // 获得用户请求的URI
	        String path = servletRequest.getRequestURI();
	        //System.out.println("用户请求的URI : "+path);
	        
	        // 从session里取userName
	        String userName = (String) session.getAttribute("LoginUserName");
	     
	         // 样式与脚本文件无需过滤 bootstrap  images scripts style 
	        if(		path.indexOf("bootstrap") > -1
	        	|| 	path.indexOf("images") > -1
	        	|| 	path.indexOf("scripts") > -1
	        	|| 	path.indexOf("style") > -1
	        	|| 	path.indexOf("tools") > -1
	        		) {
	            chain.doFilter(servletRequest, servletResponse);
	            return;
	        }
	        
	        //  登陆页面
	        if(path.indexOf("/index.jsp") > -1) {
	        	//清除用户名
	        	session.setAttribute("userName", "");
	        	//继续此次请求
	        	chain.doFilter(servletRequest, servletResponse);
	        	return;
	        }
	        
	        //退出操作
	        if(path.indexOf("/logout.jsp") > -1) {
	        	//清除用户名
	        	session.setAttribute("userName", "");
	        	// 跳转到登陆页面
	            servletResponse.sendRedirect("/ty-pms/index.jsp");
	            return;
	        }

	        // 判断如果没有userName,就跳转到登陆页面
	        if (userName == null || "".equals(userName)) {
	            // 跳转到登陆页面
	            servletResponse.sendRedirect("/ty-pms/index.jsp");
	        } else {
	            // 已经登陆,继续此次请求
	            chain.doFilter(request, response);
	        }
	    }
}
