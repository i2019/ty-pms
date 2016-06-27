package ty.pms.model.account.expenditure;

import ty.pms.model.base.BaseObject;

public class Expenditure extends BaseObject{
 
	private String expenditureId;
	private String expenditureAmount;
	private String causeId;
	private String unitId;

	public String getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(String expenditureId) {
		this.expenditureId = expenditureId;
	}
	public String getExpenditureAmount() {
		return expenditureAmount;
	}
	public void setExpenditureAmount(String expenditureAmount) {
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
	
}
