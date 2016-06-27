package ty.pms.dao.account.income;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ty.pms.dao.common.unit.UnitMapper;
import ty.pms.model.account.income.Income;
import ty.pms.model.account.income.IncomeCriteria;
import ty.pms.model.common.unit.Unit;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class IncomeTest extends BaseTest<IncomeMapper> {

	
	private static IncomeMapper incomeMapper;
	
	@Before
	public void setUp() throws Exception {
		incomeMapper = init("incomeMapper");
	}

	@Test
	public void test() {
		Income record=new Income();
		String id=CommonUtil.generateUUID();
		record.setIncomeId(id);
		record.setIncomeAmount(new BigDecimal("1029"+((Math.random()*Math.random())*100)));
		incomeMapper.insertSelective(record);
		//incomeMapper.deleteByPrimaryKey("1323e33a274149c38410212885ddc4d7");
		IncomeCriteria criteria=new IncomeCriteria();
		criteria.setIncomeAmountBegin(new BigDecimal("1029"));
		List<Income> is=incomeMapper.getByCriteria(criteria);
		System.out.println("结果数："+is.size()+"----- count数："+incomeMapper.getByCriteriaCount(criteria));
		for (Income i : is) {
			System.out.println(i);
		}
	}

}
