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
