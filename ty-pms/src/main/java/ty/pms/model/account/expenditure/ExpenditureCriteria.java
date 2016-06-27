package ty.pms.model.account.expenditure;

import java.math.BigDecimal;
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
	
	private BigDecimal expenditureAmount;
	private BigDecimal expenditureAmountBegin;
	private BigDecimal expenditureAmountEnd;
	
	private String causeId;
	private List<String> causeIdList;
	
	private String unitId;
	private List<String> unitIdList;

	
	public BigDecimal getExpenditureAmount() {
		return expenditureAmount;
	}
	public void setExpenditureAmount(BigDecimal expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}
	public BigDecimal getExpenditureAmountBegin() {
		return expenditureAmountBegin;
	}
	public void setExpenditureAmountBegin(BigDecimal expenditureAmountBegin) {
		this.expenditureAmountBegin = expenditureAmountBegin;
	}
	public BigDecimal getExpenditureAmountEnd() {
		return expenditureAmountEnd;
	}
	public void setExpenditureAmountEnd(BigDecimal expenditureAmountEnd) {
		this.expenditureAmountEnd = expenditureAmountEnd;
	}
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
