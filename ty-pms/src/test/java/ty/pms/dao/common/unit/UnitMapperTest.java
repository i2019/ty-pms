package ty.pms.dao.common.unit;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import ty.pms.dao.common.unit.UnitMapper;
import ty.pms.model.common.unit.Unit;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class UnitMapperTest extends BaseTest<UnitMapper> {

	
	private static UnitMapper unitMapper;
	
	@Before
	public void setUp() throws Exception {
		unitMapper = init("unitMapper");
	}

	@Test
	public void test() {
		//Integer id=unitMapper.deleteByPrimaryKey("1");
		//System.out.println(id);
		//assertEquals(new Integer(1), id);
		Unit record=new Unit();
		record.setUnitId(CommonUtil.generateUUID());
		record.setUnitName("N-"+(CommonUtil.generateUUID().substring(28) ));
		record.setOccurrencedTime(new Date());
		//unitMapper.insertSelective(record);
		
		record=unitMapper.selectByName("yuan");
		System.out.println(record);
		
	}

}
