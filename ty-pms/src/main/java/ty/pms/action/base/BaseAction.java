package ty.pms.action.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import ty.pms.model.sys.user.User;
import ty.pms.util.Constants;

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
	
	public User getLoginUser() {
		HttpSession httpSession=getHttpSession();
		User loginUser=null;
		if(null!=httpSession){
			loginUser=(User) httpSession.getAttribute("LoginUser");
		}
		return loginUser;
	}
	public void setLoginUser(User user){
		HttpSession httpSession=getHttpSession();
		if(httpSession!=null){
			httpSession.setAttribute("LoginUser", user);
			httpSession.setAttribute("LoginUserName", user.getUserName());
			httpSession.setAttribute("LoginUserId", user.getUserId());
		}
	}
	
	// 取得每页多少条
	public int getCurrentPageSize(String tableId) {
		int pageNumber = Constants.PAGE_SIZE;
		return pageNumber;
	}
	// 取得当前页
	public int getCurrentPageNo(String tableId) {
		String pageId = new ParamEncoder(tableId).encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		// 从请求中取得当前页，如不存在设置第一页为默认页
		int pageNumber = 1;
		if (StringUtils.isNotEmpty(getRequest().getParameter(pageId))) {
			pageNumber = Integer.parseInt(getRequest().getParameter(pageId));
		}
		return pageNumber;
	}
}
