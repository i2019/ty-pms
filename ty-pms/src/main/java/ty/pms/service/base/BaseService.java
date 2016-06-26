package ty.pms.service.base;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;

public class BaseService {

	private HttpSession httpSession=null;

	private User loginUser=null;
	
	public HttpSession getHttpSession() {
		httpSession=ServletActionContext.getRequest().getSession();
		return httpSession;
	}

	public User getLoginUser() {
		HttpSession httpSession=getHttpSession();
		if(null!=httpSession){
			loginUser=(User) httpSession.getAttribute("LoginUser");
		}
		return loginUser;
	}

}
