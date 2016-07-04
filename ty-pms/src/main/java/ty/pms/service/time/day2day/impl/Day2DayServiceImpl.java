package ty.pms.service.time.day2day.impl;

import java.util.List;

import ty.pms.dao.time.day2day.Day2DayMapper;
import ty.pms.model.time.day2day.Day2Day;
import ty.pms.model.time.day2day.Day2DayCriteria;
import ty.pms.model.time.day2day.Day2DayResult;
import ty.pms.service.base.BaseService;
import ty.pms.service.time.day2day.Day2DayService;

public class Day2DayServiceImpl extends BaseService implements Day2DayService{
	
	private Day2DayMapper mapper;
	
	@Override
	public Integer insertSelective(Day2Day record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateByPrimaryKeySelective(Day2Day record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day2Day selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Day2Day> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day2DayResult getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day2DayResult getByCriteria(Day2DayCriteria criteria) {
		
		Day2DayResult result=new Day2DayResult();
		result.setResultList(mapper.getByCriteria(criteria));
		result.setTotalCount(mapper.getByCriteriaCount(criteria));
		
		return result;
	}

	public Day2DayMapper getMapper() {
		return mapper;
	}

	public void setMapper(Day2DayMapper mapper) {
		this.mapper = mapper;
	}

}
