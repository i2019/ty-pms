package ty.pms.service.account.expenditure.impl;

import java.util.Date;
import java.util.List;
import ty.pms.dao.account.expenditure.ExpenditureMapper;
import ty.pms.model.account.expenditure.Expenditure;
import ty.pms.model.account.expenditure.ExpenditureCriteria;
import ty.pms.model.account.expenditure.ExpenditureResult;
import ty.pms.model.sys.user.User;
import ty.pms.service.account.expenditure.ExpenditureService;
import ty.pms.service.base.BaseService;
import ty.pms.util.CommonUtil;

public class ExpenditureServiceImpl extends BaseService implements ExpenditureService {
	
	private ExpenditureMapper mapper;

	/**
	 * 插入新纪录（不为空的字段）,返回影响的行数
	 */
	@Override
	public Integer insertSelective(Expenditure record) {
		
		record.setExpenditureId(CommonUtil.generateUUID());
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
	public Integer updateByPrimaryKeySelective(Expenditure record){
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
	public Expenditure selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据名字获取对象
	 */
	@Override
	public List<Expenditure> selectByName(String name) {
		return mapper.selectByName(name);
	}
	
	/*
	 * 获取所有对象
	 */
	@Override
	public ExpenditureResult getAll(){
		ExpenditureResult result=new ExpenditureResult();
		result.setResultList(mapper.getAll());
		result.setTotalCount(mapper.getAllCount());
		return result;
	}
	

	@Override
	public ExpenditureResult getByCriteria(ExpenditureCriteria criteria){
		ExpenditureResult result=new ExpenditureResult();
		result.setResultList(mapper.getByCriteria(criteria));
		result.setTotalCount(mapper.getByCriteriaCount(criteria));
		return result;
	}

	public ExpenditureMapper getMapper() {
		return mapper;
	}

	public void setMapper(ExpenditureMapper mapper) {
		this.mapper = mapper;
	}
	
}
