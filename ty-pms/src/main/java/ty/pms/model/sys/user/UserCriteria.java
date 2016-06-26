package ty.pms.model.sys.user;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class UserCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7090400382971260627L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private List<String> userNameList;
	private String userName;//操作员名称
	
	private String userId;//操作员id
	private List<String> userIdList;

	private String password;//密码
	private List<String> passList;
	
	
	public List<String> getPassList() {
		return passList;
	}
	public void setPassList(List<String> passList) {
		this.passList = passList;
	}
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
	@Override
	public String toString() {
		return "UserCriteria [userNameList=" + userNameList + ", userName="
				+ userName + ", userId=" + userId + ", userIdList="
				+ userIdList + ", password=" + password + ", passList="
				+ passList + ", getPassList()=" + getPassList()
				+ ", getUserId()=" + getUserId() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword()
				+ ", getUserNameList()=" + getUserNameList()
				+ ", getUserIdList()=" + getUserIdList()
				+ ", getSkipResults()=" + getSkipResults()
				+ ", getMaxResults()=" + getMaxResults() + ", getPageSize()="
				+ getPageSize() + ", getPageNum()=" + getPageNum()
				+ ", getSortBy()=" + getSortBy() + ", getDesc()=" + getDesc()
				+ ", getTotal()=" + getTotal() + ", isNeedPage()="
				+ isNeedPage() + ", getStart()=" + getStart()
				+ ", getOwnerList()=" + getOwnerList()
				+ ", getCreatedByList()=" + getCreatedByList()
				+ ", getUpdatedByList()=" + getUpdatedByList()
				+ ", getCreatedTimeBegin()=" + getCreatedTimeBegin()
				+ ", getCreatedTimeEnd()=" + getCreatedTimeEnd()
				+ ", getLastModifyTimeBegin()=" + getLastModifyTimeBegin()
				+ ", getLastModifyTimeEnd()=" + getLastModifyTimeEnd()
				+ ", getOccurrencedTimeBegin()=" + getOccurrencedTimeBegin()
				+ ", getOccurrencedTimeEnd()=" + getOccurrencedTimeEnd()
				+ ", getEndTimeBegin()=" + getEndTimeBegin()
				+ ", getEndTimeEnd()=" + getEndTimeEnd() + ", getEndTime()="
				+ getEndTime() + ", getOwner()=" + getOwner()
				+ ", getOccurrencedTime()=" + getOccurrencedTime()
				+ ", getCreatedTime()=" + getCreatedTime()
				+ ", getLastModifyTime()=" + getLastModifyTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", getRemark()=" + getRemark()
				+ ", isDelFlag()=" + isDelFlag() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
