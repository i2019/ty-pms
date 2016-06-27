package ty.pms.model.time.day2day;

import java.util.List;

import ty.pms.model.base.SearchCriteria;

public class Day2DayCriteria extends SearchCriteria{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3632743294237517716L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String d2Id;
	private List<String> d2IdList;
	
	private String d2Descrip;
	private List<String> d2DescripList;

	public String getD2Id() {
		return d2Id;
	}
	public void setD2Id(String d2Id) {
		this.d2Id = d2Id;
	}
	public List<String> getD2IdList() {
		return d2IdList;
	}
	public void setD2IdList(List<String> d2IdList) {
		this.d2IdList = d2IdList;
	}
	public String getD2Descrip() {
		return d2Descrip;
	}
	public void setD2Descrip(String d2Descrip) {
		this.d2Descrip = d2Descrip;
	}
	public List<String> getD2DescripList() {
		return d2DescripList;
	}
	public void setD2DescripList(List<String> d2DescripList) {
		this.d2DescripList = d2DescripList;
	}

}
