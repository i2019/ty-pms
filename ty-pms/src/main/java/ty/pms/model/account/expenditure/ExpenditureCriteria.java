package ty.pms.model.account.expenditure;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class ExpenditureCriteria extends SearchCriteria{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3698811956666340191L;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String expenditureId;
	private List<String> expenditureIdList;
	
	private String expenditureAmount;
	private List<String> expenditureAmountList;
	
	private String causeId;
	private List<String> causeIdList;
	
	private String unitId;
	private List<String> unitIdList;

	
	public String getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(String expenditureId) {
		this.expenditureId = expenditureId;
	}
	public List<String> getExpenditureIdList() {
		return expenditureIdList;
	}
	public void setExpenditureIdList(List<String> expenditureIdList) {
		this.expenditureIdList = expenditureIdList;
	}
	public String getExpenditureAmount() {
		return expenditureAmount;
	}
	public void setExpenditureAmount(String expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}
	public List<String> getExpenditureAmountList() {
		return expenditureAmountList;
	}
	public void setExpenditureAmountList(List<String> expenditureAmountList) {
		this.expenditureAmountList = expenditureAmountList;
	}
	public String getCauseId() {
		return causeId;
	}
	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}
	public List<String> getCauseIdList() {
		return causeIdList;
	}
	public void setCauseIdList(List<String> causeIdList) {
		this.causeIdList = causeIdList;
	}
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
	
	
}
