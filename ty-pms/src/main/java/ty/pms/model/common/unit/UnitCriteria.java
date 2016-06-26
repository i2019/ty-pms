package ty.pms.model.common.unit;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class UnitCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7090400382971260627L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String unitId;//单位id
	private List<String> unitIdList;
	
	private String unitName;//单位名称
	private List<String> unitNameList;

	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public List<String> getUnitIdList() {
		return unitIdList;
	}
	public void setUnitIdList(List<String> unitIdList) {
		this.unitIdList = unitIdList;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public List<String> getUnitNameList() {
		return unitNameList;
	}
	public void setUnitNameList(List<String> unitNameList) {
		this.unitNameList = unitNameList;
	}
	@Override
	public String toString() {
		return "UnitCriteria [unitId=" + unitId + ", unitIdList=" + unitIdList
				+ ", unitName=" + unitName + ", unitNameList=" + unitNameList
				+ ", getUnitId()=" + getUnitId() + ", getUnitIdList()="
				+ getUnitIdList() + ", getUnitName()=" + getUnitName()
				+ ", getUnitNameList()=" + getUnitNameList()
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
