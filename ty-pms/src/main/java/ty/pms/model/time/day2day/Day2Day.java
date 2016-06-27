package ty.pms.model.time.day2day;

import ty.pms.model.base.BaseObject;

public class Day2Day extends BaseObject{

	private String d2Id;
	private String d2Descrip;
	public String getD2Id() {
		return d2Id;
	}
	public void setD2Id(String d2Id) {
		this.d2Id = d2Id;
	}
	public String getD2Descrip() {
		return d2Descrip;
	}
	public void setD2Descrip(String d2Descrip) {
		this.d2Descrip = d2Descrip;
	}
	@Override
	public String toString() {
		return "Day2Day [d2Id=" + d2Id + ", d2Descrip=" + d2Descrip + "]";
	}

	
}
