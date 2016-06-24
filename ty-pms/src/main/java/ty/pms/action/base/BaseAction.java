package ty.pms.action.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
}
