package ty.pms.model.user;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class UserCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7090400382971260627L;

	private List<String> userNameList;
	private List<String> userIdList;
	
	private String userId;//操作员id
	private String userName;//操作员名称
	private String password;//密码
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<String> getUserNameList() {
		return userNameList;
	}
	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}
	public List<String> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}
	
}
