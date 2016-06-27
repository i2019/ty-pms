package ty.pms.model.account.income;

import java.math.BigDecimal;

import ty.pms.model.base.BaseObject;

public class Income extends BaseObject{
	
	private String incomeId;
	private BigDecimal incomeAmount;
	private String causeId;
	private String unitId;
	
	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
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
		return "Income [incomeId=" + incomeId + ", incomeAmount="
				+ incomeAmount + ", causeId=" + causeId + ", unitId=" + unitId
				+ ", getEndTime()=" + getEndTime() + ", getOwner()="
				+ getOwner() + ", getOccurrencedTime()=" + getOccurrencedTime()
				+ ", getCreatedTime()=" + getCreatedTime()
				+ ", getLastModifyTime()=" + getLastModifyTime()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", getRemark()=" + getRemark()
				+ ", isDelFlag()=" + isDelFlag() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
