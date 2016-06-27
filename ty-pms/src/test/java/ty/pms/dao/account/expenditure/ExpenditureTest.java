package ty.pms.dao.account.expenditure;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ty.pms.dao.common.unit.UnitMapper;
import ty.pms.model.account.expenditure.Expenditure;
import ty.pms.model.common.unit.Unit;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class ExpenditureTest extends BaseTest<ExpenditureMapper> {

	
	private static ExpenditureMapper expenditureMapper;
	
	@Before
	public void setUp() throws Exception {
		expenditureMapper = init("expenditureMapper");
	}

	@Test
	public void test() {
		Expenditure record=new Expenditure();
		String id=CommonUtil.generateUUID();
		record.setExpenditureId(id);
		record.setExpenditureAmount(new BigDecimal("1029"+((Math.random()*Math.random())*100)));
		expenditureMapper.insertSelective(record);
		
		
		System.out.println(expenditureMapper.selectByPrimaryKey("ff7e07416f2243979dc8d14c1c47d590"));
		
	}

}
