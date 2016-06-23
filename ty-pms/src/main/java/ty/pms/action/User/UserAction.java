package ty.pms.action.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import ty.pms.action.base.BaseAction;
import ty.pms.model.user.User;
import ty.pms.service.user.UserService;

public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;
	
	private User user;
	
	private List<User> userList=new ArrayList<User>();
	
    @Autowired
	private UserService userService;

	public String list() {
		//获取所有用户
		List<User> users=userService.getAll();
		if(null!=user){
			userList=users;
		}
		userList=users;
		//获取当前用户
		HttpSession httpSession=getHttpSession();
		user=(User) httpSession.getAttribute("LoginUser");
		
		return "list";
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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
