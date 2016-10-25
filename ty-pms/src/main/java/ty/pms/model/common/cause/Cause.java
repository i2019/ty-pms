package ty.pms.model.common.cause;

import ty.pms.model.base.BaseObject;

public class Cause extends BaseObject{
	
	private String causeId;
	private String causeName;
	
	private String parentId;
	private Integer causeType;
	
	public Integer getCauseType() {
		return causeType;
	}

	public void setCauseType(Integer causeType) {
		this.causeType = causeType;
	}

	public String getCauseId() {
		return causeId;
	}

	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}
