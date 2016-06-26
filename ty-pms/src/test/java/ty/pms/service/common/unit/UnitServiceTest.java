package ty.pms.service.common.unit;

import org.junit.Before;
import org.junit.Test;

import ty.pms.model.common.unit.Unit;

import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class UnitServiceTest  extends BaseTest<UnitService> {

	private static UnitService unitService;
	
	@Before
	public void setUp() throws Exception {
		unitService = init("unitService");
	}

	@Test
	public void test(){
		Unit record=new Unit();
		//record.setUnitId(CommonUtil.generateUUID());
		record.setUnitName("UN-"+CommonUtil.generateUUID().substring(28));
		unitService.insertSelective(record);
	}

	public static UnitService getUnitService() {
		return unitService;
	}

	public static void setUnitService(UnitService unitService) {
		UnitServiceTest.unitService = unitService;
	}

}
