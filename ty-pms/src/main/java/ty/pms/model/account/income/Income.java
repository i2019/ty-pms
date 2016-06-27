package ty.pms.model.account.income;

import ty.pms.model.base.BaseObject;

public class Income extends BaseObject{
	 
	private String incomeId;
	private String incomeAmount;
	private String causeId;
	private String unitId;
	
	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
	public String getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(String incomeAmount) {
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
	
}
