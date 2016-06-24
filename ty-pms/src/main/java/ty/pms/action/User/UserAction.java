package ty.pms.action.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.pms.action.base.BaseAction;
import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.service.user.UserService;

public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;
	
	private User user;
	private UserCriteria userCriteria;
	
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
		/*
		//获取当前用户
		HttpSession httpSession=getHttpSession();
		user=(User) httpSession.getAttribute("LoginUser");
		*/
		return "list";
	}
	/**
	 * 编辑或新增
	 * @return
	 */
	public String edit(){
		
		return "edit";
	}
	
	public String save(){
		String userName=userCriteria.getUserName();
		if(null!=userCriteria 
				&& StringUtils.hasText(userCriteria.getPassword())
				&& StringUtils.hasText(userName)){
			if(null!=userService.selectUserByName(userName)){
				getRequest().setAttribute("RepeatedUserName", userName);
				return "edit";
			}
			userService.insertSelective(userCriteria);
		}
		return "list";
	}
	
	public void ajaxVerifyOnly(){
		String userName = getRequest().getParameter("userName");
		if(StringUtils.hasText(userName)){
			if(null!=userService.selectUserByName(userName)){
				JSONObject repeatedUserName=new JSONObject();
				repeatedUserName.put("repeatedUserName",userName);
				JSONArray jArr=new JSONArray();
				jArr.add(repeatedUserName);
				ajaxResponse(jArr.toString());
			}
		}
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
	public UserCriteria getUserCriteria() {
		return userCriteria;
	}
	public void setUserCriteria(UserCriteria userCriteria) {
		this.userCriteria = userCriteria;
	}

}
