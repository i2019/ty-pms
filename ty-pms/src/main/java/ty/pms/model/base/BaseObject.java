package ty.pms.model.base;

import java.util.Date;

public class BaseObject {
	  private String id;//默认id
	  private Date occurrencedTime;//发生时间
	  private Date endTime;//结束时间
	  private String owner;//所有者
	  private Date createdTime;//创建时间
	  private Date lastModifyTime;//修改时间
      private String createdBy;//创建者
      private String updatedBy;//修改者
      private String remark;//备注
      private boolean delFlag;//删除标志
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getOccurrencedTime() {
		return occurrencedTime;
	}
	public void setOccurrencedTime(Date occurrencedTime) {
		this.occurrencedTime = occurrencedTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
      
}
