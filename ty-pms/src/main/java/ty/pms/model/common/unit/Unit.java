package ty.pms.model.common.unit;

import ty.pms.model.base.BaseObject;

public class Unit extends BaseObject{
	 
	private String unitId;//单位id
	private String unitName;//单位名称
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", unitName=" + unitName
				+ ", getUnitId()=" + getUnitId() + ", getUnitName()="
				+ getUnitName() + ", getEndTime()=" + getEndTime()
				+ ", getOwner()=" + getOwner() + ", getOccurrencedTime()="
				+ getOccurrencedTime() + ", getCreatedTime()="
				+ getCreatedTime() + ", getLastModifyTime()="
				+ getLastModifyTime() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getUpdatedBy()=" + getUpdatedBy() + ", getRemark()="
				+ getRemark() + ", isDelFlag()=" + isDelFlag()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
