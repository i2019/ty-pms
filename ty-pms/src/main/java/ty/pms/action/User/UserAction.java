package ty.pms.action.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.pms.action.base.BaseAction;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.model.sys.user.UserResult;
import ty.pms.service.sys.user.UserService;

public class UserAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269552141446088700L;
	
	private Log log = LogFactory.getLog(UserAction.class);
	
	private String userId;
	private User user;
	private UserCriteria userCriteria=new UserCriteria();
	private UserResult userResult=new UserResult();
	private List<User> userList=new ArrayList<User>();
	private List<String> userNameList=new ArrayList<String>();
	private User loginUser;
	
    @Autowired
	private UserService userService;
	/**
	 * 查询并展示
	 * @return
	 */
	public String list() {
		
		loginUser=getLoginUser();
		
		//displaytag 分页
		int pageSize = this.getCurrentPageSize("userList");
		int pageNo = this.getCurrentPageNo("userList");
		userCriteria.setPageNum(pageNo);
		userCriteria.setPageSize(pageSize);

		if(!StringUtils.hasText(userCriteria.getUserName())){
			userCriteria.setUserName(null);
		}
		
		userResult=userService.getByCriteria(userCriteria);
		
		//log.debug(userResult);
		log.info("userList count :"+userResult.getTotalCount());
		
		//查询条件
		userNameList=userService.getUserNameList();
		
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
		
		//查询条件
		userNameList=userService.getUserNameList();
				
		return "edit";
	}
	/**
	 * 删除用户
	 * @return
	 */
	public String del(){
		loginUser=getLoginUser();
		if(StringUtils.hasText(userId) && null!=loginUser){
			//当前登录用户不可删除自己
			if(!userId.equalsIgnoreCase(loginUser.getUserId())){
				userService.deleteByPrimaryKey(userId);
			}
		}
		//查询条件
		userNameList=userService.getUserNameList();
				
		return list();
	}
	/**
	 * 新增或者编辑保存
	 * @return
	 */
	public String save(){
		loginUser=getLoginUser();
		String userName=user.getUserName();
		//用户名密码必填
		if(null!=user 
		&& StringUtils.hasText(user.getPassword())
		&& StringUtils.hasText(userName)){	
			//如果存在用户id，则为编辑，后台update
			if(StringUtils.hasText(user.getUserId())){
				userService.updateByPrimaryKeySelective(user);
				if(user.getUserId().equalsIgnoreCase(loginUser.getUserId())){
					setLoginUser(userService.selectByPrimaryKey(user.getUserId()));	
				}
			}else{
			//如果不存在用户id，则为新增，后台insert
				//用户名唯一，否则返回编辑页面
				if(null!=userService.selectByName(userName)){
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
			if(null!=userService.selectByName(userName)){
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
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	
}
