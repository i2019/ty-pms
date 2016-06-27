package ty.pms.dao.time.day2day;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ty.pms.model.time.day2day.Day2Day;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class Day2DayMapperTest extends BaseTest<Day2DayMapper> {

	
	private static Day2DayMapper day2DayMapper;
	
	@Before
	public void setUp() throws Exception {
		day2DayMapper = init("day2DayMapper");
	}

	@Test
	public void test() {
		//Integer id=unitMapper.deleteByPrimaryKey("1");
		//System.out.println(id);
		//assertEquals(new Integer(1), id);
		Day2Day record=new Day2Day();
		record.setD2Id(CommonUtil.generateUUID());
		record.setD2Descrip("Desc-"+(CommonUtil.generateUUID().substring(25) ));
		record.setOccurrencedTime(new Date());
		
		//day2DayMapper.insertSelective(record);
		
		List<Day2Day> ds= day2DayMapper.selectByName("洗漱,吃了点粥,然后骑自行车去公司");
		System.out.println(ds);
//		for (Day2Day day2Day : ds) {
//			System.out.println(day2Day);
//		}
		//System.out.println(record);
		
	}

}
