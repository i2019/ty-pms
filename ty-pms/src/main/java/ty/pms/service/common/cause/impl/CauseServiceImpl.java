package ty.pms.service.common.cause.impl;

import java.util.Date;
import java.util.List;

import ty.pms.dao.common.cause.CauseMapper;
import ty.pms.model.common.cause.Cause;
import ty.pms.model.common.cause.CauseCriteria;
import ty.pms.model.common.cause.CauseResult;
import ty.pms.model.sys.user.User;
import ty.pms.service.base.BaseService;
import ty.pms.service.common.cause.CauseService;
import ty.pms.util.CommonUtil;

public class CauseServiceImpl extends BaseService implements CauseService{

	private CauseMapper mapper;
	public CauseMapper getMapper() {
		return mapper;
	}
	public void setMapper(CauseMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * 插入新纪录（不为空的字段）,返回影响的行数
	 */
	@Override
	public Integer insertSelective(Cause record) {
		
		record.setCauseId(CommonUtil.generateUUID());
		record.setDelFlag(false);
		
		record.setCreatedTime(new Date());
		record.setLastModifyTime(new Date());
		//消费时间
		//record.setOccurrencedTime(new Date()); 
		//record.setEndTime(new Date());	
		
		User loginUser=null;
		loginUser=getLoginUser();
		if(null!=loginUser){
			String userId=loginUser.getUserId();
			record.setCreatedBy(userId);
			record.setUpdatedBy(userId);
			//消费者
			//record.setOwner(userId); 
		}
		
		return mapper.insertSelective(record);
	}
	
	/**
	 * 根据用户id更新用户信息,返回影响的行数
	 */
	@Override
	public Integer updateByPrimaryKeySelective(Cause record){
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public Integer deleteByPrimaryKey(String id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据id获取对象
	 */
	@Override
	public Cause selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据名字获取对象
	 */
	@Override
	public List<Cause> selectByName(String name) {
		return mapper.selectByName(name);
	}
	
	/*
	 * 获取所有对象
	 */
	@Override
	public CauseResult getAll(){
		CauseResult result=new CauseResult();
		result.setResultList(mapper.getAll());
		result.setTotalCount(mapper.getAllCount());
		return result;
	}
	

	@Override
	public CauseResult getByCriteria(CauseCriteria criteria){
		CauseResult result=new CauseResult();
		result.setResultList(mapper.getByCriteria(criteria));
		result.setTotalCount(mapper.getByCriteriaCount(criteria));
		return result;
	}
	
}
