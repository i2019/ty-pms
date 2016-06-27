package ty.pms.model.health.menst;

import ty.pms.model.base.BaseObject;

public class Menst extends BaseObject{

	private String menstId;

	public String getMenstId() {
		return menstId;
	}

	public void setMenstId(String menstId) {
		this.menstId = menstId;
	}

	@Override
	public String toString() {
		return "Menst [menstId=" + menstId + ", getEndTime()=" + getEndTime()
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
