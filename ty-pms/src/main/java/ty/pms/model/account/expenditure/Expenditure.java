package ty.pms.model.account.expenditure;

import java.math.BigDecimal;

import ty.pms.model.base.BaseObject;

public class Expenditure extends BaseObject{
 
	private String expenditureId;
	private BigDecimal expenditureAmount;
	private String causeId;
	private String unitId;
	  //private Date occurrencedTime;//支出发生时间 
	  //private Date endTime;//支出结束时间
	  //private String owner;//支出所有者
	public String getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(String expenditureId) {
		this.expenditureId = expenditureId;
	}
	
	public BigDecimal getExpenditureAmount() {
		return expenditureAmount;
	}
	public void setExpenditureAmount(BigDecimal expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}
	public String getCauseId() {
		return causeId;
	}
	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	@Override
	public String toString() {
		return "Expenditure [expenditureId=" + expenditureId
				+ ", expenditureAmount=" + expenditureAmount + ", causeId="
				+ causeId + ", unitId=" + unitId + ", getEndTime()="
				+ getEndTime() + ", getOwner()=" + getOwner()
				+ ", getOccurrencedTime()=" + getOccurrencedTime()
				+ ", getCreatedTime()=" + getCreatedTime()
				+ ", getLastModifyTime()=" + getLastModifyTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", getRemark()=" + getRemark()
				+ ", isDelFlag()=" + isDelFlag() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
