package ty.pms.service.base;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;

public class BaseService {

	private HttpSession httpSession=null;

	private UserCriteria loginUser;
	
	public HttpSession getHttpSession() {
		httpSession=ServletActionContext.getRequest().getSession();
		return httpSession;
	}

	public UserCriteria getLoginUser() {
		HttpSession httpSession=getHttpSession();
		if(null!=httpSession){
			loginUser=(UserCriteria) httpSession.getAttribute("LoginUser");
		}
		return loginUser;
	}

}
