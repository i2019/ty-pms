package ty.pms.model.common.cause;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class CauseCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7090400382971260627L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String causeId;
	private List<String> causeIdList;
	
	private String causeName;
	private List<String> causeNameList;

	private String parentId;
	private List<String> parentIdList;

	public String getCauseId() {
		return causeId;
	}
	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}
	public List<String> getCauseIdList() {
		return causeIdList;
	}
	public void setCauseIdList(List<String> causeIdList) {
		this.causeIdList = causeIdList;
	}
	public String getCauseName() {
		return causeName;
	}
	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}
	public List<String> getCauseNameList() {
		return causeNameList;
	}
	public void setCauseNameList(List<String> causeNameList) {
		this.causeNameList = causeNameList;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<String> getParentIdList() {
		return parentIdList;
	}
	public void setParentIdList(List<String> parentIdList) {
		this.parentIdList = parentIdList;
	}
	@Override
	public String toString() {
		return "CauseCriteria [causeId=" + causeId + ", causeIdList="
				+ causeIdList + ", causeName=" + causeName + ", causeNameList="
				+ causeNameList + ", parentId=" + parentId + ", parentIdList="
				+ parentIdList + ", getSkipResults()=" + getSkipResults()
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
