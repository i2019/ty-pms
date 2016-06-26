package ty.pms.action.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import ty.pms.action.base.Action;
import ty.pms.action.base.BaseAction;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.service.sys.user.UserService;

public class LoginAction extends BaseAction implements Action{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;

	private User user;
	private String userName;
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
					setLoginUser(user);	
					return "success";
				}
			}
		}
		
		return "fail";
	}

	public String relogin(){
		return "relogin";
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
