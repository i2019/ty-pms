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
	private UserCriteria userCriteria=new UserCriteria();
	private UserResult userResult=new UserResult();
	private List<User> userList=new ArrayList<User>();
	private List<String> userNameList=new ArrayList<String>();

    @Autowired
	private UserService userService;
	/**
	 * 查询并展示
	 * @return
	 */
	public String list() {
		
		if(!StringUtils.hasText(userCriteria.getUserName())){
			userCriteria.setUserName(null);
		}
		
		userResult=userService.getUsers(userCriteria);
		
		return "list";
	}
	/**
	 * 编辑或新增
	 * @return
	 */
	public String edit(){
		if(StringUtils.hasText(userId)){
			user=userService.selectByPrimaryKey(userId);	
		}
		return "edit";
	}
	/**
	 * 删除用户
	 * @return
	 */
	public String del(){
		if(StringUtils.hasText(userId)){
			userService.deleteByPrimaryKey(userId);
		}
		return list();
	}
	/**
	 * 新增或者编辑保存
	 * @return
	 */
	public String save(){
		String userName=user.getUserName();
		//用户名密码必填
		if(null!=user 
		&& StringUtils.hasText(user.getPassword())
		&& StringUtils.hasText(userName)){	
			//如果存在用户id，则为编辑，后台update
			if(StringUtils.hasText(user.getUserId())){
				userService.updateByPrimaryKeySelective(user);
			}else{
			//如果不存在用户id，则为新增，后台insert
				//用户名唯一，否则返回编辑页面
				if(null!=userService.selectUserByName(userName)){
					getRequest().setAttribute("RepeatedUserName", userName);
					return "edit";
				}
				userService.insertSelective(user);
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
	public List<String> getUserNameList() {
		return userNameList;
	}
	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}

}
