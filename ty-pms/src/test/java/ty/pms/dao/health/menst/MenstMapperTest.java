package ty.pms.dao.health.menst;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ty.pms.model.health.menst.Menst;
import ty.pms.model.time.day2day.Day2Day;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class MenstMapperTest extends BaseTest<MenstMapper> {

	
	private static MenstMapper menstMapper;
	
	@Before
	public void setUp() throws Exception {
		menstMapper = init("menstMapper");
	}

	@Test
	public void test() {

		Menst record=new Menst();
		record.setMenstId(CommonUtil.generateUUID());
		record.setOccurrencedTime(new Date());
		
		menstMapper.insertSelective(record);
	
		
	}

}
