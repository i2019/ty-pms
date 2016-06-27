package ty.pms.model.common.cause;

import ty.pms.model.base.BaseObject;

public class Cause extends BaseObject{
	 
	private String causeId;
	private String causeName;
	
	private String parentId;
	//ALTER TABLE cause ADD COLUMN parentId VARCHAR(32) DEFAULT NULL COMMENT '父Id';

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
