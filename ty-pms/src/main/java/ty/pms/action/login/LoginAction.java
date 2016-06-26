package ty.pms.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import ty.pms.action.base.BaseAction;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.service.sys.user.UserService;

public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;

	private User user;

	private UserService userService;
	
	private UserCriteria userCriteria;

	public String execute() {
		HttpServletRequest request=getRequest();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		if(StringUtils.hasText(username) && StringUtils.hasText(password)){
			user=userService.selectByName(username);
			if(null!=user){
				if(user.getPassword().equals(password)){
					HttpSession httpSession=getHttpSession();
					httpSession.setAttribute("LoginUser", user);
					return "success";
				}
			}
		}
		
		return "fail";
	}

	public UserCriteria getUserCriteria() {
		return userCriteria;
	}

	public void setUserCriteria(UserCriteria userCriteria) {
		this.userCriteria = userCriteria;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
