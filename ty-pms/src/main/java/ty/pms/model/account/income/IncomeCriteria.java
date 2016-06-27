package ty.pms.model.account.income;

import java.math.BigDecimal;
import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class IncomeCriteria extends SearchCriteria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6232100572168400560L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String incomeId;
	private List<String> incomeIdList;
	
	private BigDecimal incomeAmount;
	private BigDecimal incomeAmountBegin;
	private BigDecimal incomeAmountEnd;
	
	private String causeId;
	private List<String> causeIdList;
	
	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public BigDecimal getIncomeAmountBegin() {
		return incomeAmountBegin;
	}
	public void setIncomeAmountBegin(BigDecimal incomeAmountBegin) {
		this.incomeAmountBegin = incomeAmountBegin;
	}
	public BigDecimal getIncomeAmountEnd() {
		return incomeAmountEnd;
	}
	public void setIncomeAmountEnd(BigDecimal incomeAmountEnd) {
		this.incomeAmountEnd = incomeAmountEnd;
	}

	private String unitId;
	private List<String> unitIdList;

	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
	public List<String> getIncomeIdList() {
		return incomeIdList;
	}
	public void setIncomeIdList(List<String> incomeIdList) {
		this.incomeIdList = incomeIdList;
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
