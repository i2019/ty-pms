package ty.pms.model.user;

import ty.pms.model.base.BaseObject;

public class User extends BaseObject{
	
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
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName+ ", password=" + password + "]";
	}
	
	
}