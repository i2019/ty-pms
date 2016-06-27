package ty.pms.model.health.menst;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class MenstCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3632743294237517716L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String menstId;
	private List<String> menstIdList;

	public String getMenstId() {
		return menstId;
	}
	public void setMenstId(String menstId) {
		this.menstId = menstId;
	}
	public List<String> getMenstIdList() {
		return menstIdList;
	}
	public void setMenstIdList(List<String> menstIdList) {
		this.menstIdList = menstIdList;
	}
	@Override
	public String toString() {
		return "MenstCriteria [menstId=" + menstId + ", menstIdList="
				+ menstIdList + ", getSkipResults()=" + getSkipResults()
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
