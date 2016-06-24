package ty.pms.action.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5534765303075140584L;
	
	@SuppressWarnings("unused")
	private HttpServletRequest request;

	@SuppressWarnings("unused")
	private HttpSession httpSession = null;
	@SuppressWarnings("unused")
	private Map<String, Object> sessionMap=null;
	
	public HttpSession getHttpSession() {
		return httpSession=ServletActionContext.getRequest().getSession();
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap=ActionContext.getContext().getSession();
	}

	public HttpServletRequest getRequest() {	
		return ServletActionContext.getRequest();
	}
	
	public void ajaxResponse(String text) {
		try {
			getResponse().getWriter().print(text);
			getResponse().getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

}
