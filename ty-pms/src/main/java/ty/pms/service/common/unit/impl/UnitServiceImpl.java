package ty.pms.service.common.unit.impl;

import java.util.Date;
import java.util.List;

import ty.pms.dao.common.unit.UnitMapper;
import ty.pms.model.common.unit.Unit;
import ty.pms.model.common.unit.UnitCriteria;
import ty.pms.model.common.unit.UnitResult;
import ty.pms.model.sys.user.User;
import ty.pms.service.base.BaseService;
import ty.pms.service.common.unit.UnitService;
import ty.pms.util.CommonUtil;

//@Service("unitService")
public class UnitServiceImpl extends BaseService implements UnitService {
	//@Autowired
	private UnitMapper mapper;

	@Override
	public Integer insertSelective(Unit record) {
		
		User loginUser=null;
		
		record.setUnitId(CommonUtil.generateUUID());
		record.setDelFlag(false);
		
		record.setCreatedTime(new Date());
		record.setLastModifyTime(new Date());
		record.setOccurrencedTime(new Date());
		record.setEndTime(new Date());	
		loginUser=getLoginUser();
		if(null!=loginUser){
			String userId=loginUser.getUserId();
			record.setCreatedBy(userId);
			record.setUpdatedBy(userId);
			record.setOwner(userId);
		}
		
		return mapper.insertSelective(record);
	}

	@Override
	public Integer updateByPrimaryKeySelective(Unit record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Integer deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Unit selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Unit> selectByName(String name) {
		return mapper.selectByName(name);
	}

	@Override
	public UnitResult getAll() {
		UnitResult result=new UnitResult();
		result.setResultList(mapper.getAll());
		result.setTotalCount(mapper.getAllCount());
		return result;
	}

	@Override
	public UnitResult getByCriteria(UnitCriteria criteria) {
		UnitResult result=new UnitResult();
		result.setResultList(mapper.getByCriteria(criteria));
		result.setTotalCount(mapper.getByCriteriaCount(criteria));
		return result;
	}

	public UnitMapper getMapper() {
		return mapper;
	}

	public void setMapper(UnitMapper mapper) {
		this.mapper = mapper;
	}

}
