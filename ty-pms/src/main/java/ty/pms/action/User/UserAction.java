package ty.pms.action.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.pms.action.base.BaseAction;
import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;
import ty.pms.service.user.UserService;

public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;
	
	private String userId;
	private User user;
	private UserCriteria userCriteria;
	
	private List<User> userList=new ArrayList<User>();
	
	private UserResult userResult=new UserResult();
	
    @Autowired
	private UserService userService;

	public String list() {
		
		//获取所有用户
		userResult=userService.getAll();
		
		UserCriteria criteria=new UserCriteria();
		
		List<String> userNameList=new ArrayList<String>();
		userNameList.add("p");
		userNameList.add("ta");
		
		criteria.setUserNameList(userNameList);
		userService.getUsers(criteria);
		
		return "list";
	}
	/**
	 * 编辑或新增
	 * @return
	 */
	public String edit(){
		if(StringUtils.hasText(userId)){
			userCriteria=userService.selectByPrimaryKey(userId);
			
		}
		return "edit";
	}
	
	public String del(){
		if(StringUtils.hasText(userId)){
			userService.deleteByPrimaryKey(userId);
		}
		return list();
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
			if(StringUtils.hasText(userCriteria.getUserId())){
				userService.updateByPrimaryKeySelective(userCriteria);
			}else{
				userService.insertSelective(userCriteria);
			}
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
	
	public UserResult getUserResult() {
		return userResult;
	}
	public void setUserResult(UserResult userResult) {
		this.userResult = userResult;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
