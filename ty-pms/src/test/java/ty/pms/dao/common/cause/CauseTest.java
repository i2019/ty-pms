package ty.pms.dao.common.cause;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ty.pms.dao.common.unit.UnitMapper;
import ty.pms.model.common.cause.Cause;
import ty.pms.model.common.unit.Unit;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class CauseTest extends BaseTest<CauseMapper> {

	
	private static CauseMapper causeMapper;
	
	@Before
	public void setUp() throws Exception {
		causeMapper = init("causeMapper");
	}

	@Test
	public void test() {
		
		Cause record=new Cause();
		record.setCauseId(CommonUtil.generateUUID());
		record.setCauseName("Ca-"+(CommonUtil.generateUUID().substring(28) ));
		record.setOccurrencedTime(new Date());
		
		causeMapper.insertSelective(record);
	}

}
