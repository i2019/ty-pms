package ty.pms.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import ty.pms.action.base.BaseAction;
import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.service.user.UserService;

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
			userCriteria=userService.selectUserByName(username);
			if(null!=userCriteria){
				if(userCriteria.getPassword().equals(password)){
					HttpSession httpSession=getHttpSession();
					httpSession.setAttribute("LoginUser", userCriteria);
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
