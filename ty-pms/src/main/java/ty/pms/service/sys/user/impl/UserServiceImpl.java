package ty.pms.service.sys.user.impl;

import java.util.Date;

import ty.pms.dao.sys.user.UserMapper;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.model.sys.user.UserResult;
import ty.pms.service.base.BaseService;
import ty.pms.service.sys.user.UserService;
import ty.pms.util.CommonUtil;

public class UserServiceImpl extends BaseService implements UserService {
	
	private UserMapper mapper;

	private User loginUser=null;
	
	/**
	 * 插入新纪录（不为空的字段）,返回影响的行数
	 */
	@Override
	public Integer insertSelective(User record) {
		
		record.setUserId(CommonUtil.generateUUID());
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
	
	/**
	 * 根据用户id更新用户信息,返回影响的行数
	 */
	@Override
	public Integer updateByPrimaryKeySelective(User record){
		return mapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public Integer deleteByPrimaryKey(String id){
		return mapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据用户id获取用户对象
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据用户名获取用户对象
	 */
	@Override
	public User selectByName(String name) {
		return mapper.selectByName(name);
	}
	
	/*
	 * 获取所有对象
	 */
	@Override
	public UserResult getAll(){
		UserResult result=new UserResult();
		result.setResultList(mapper.getAll());
		result.setTotalCount(mapper.getAllCount());
		return result;
	}
	

	@Override
	public UserResult getByCriteria(UserCriteria criteria){
		UserResult result=new UserResult();
		result.setResultList(mapper.getByCriteria(criteria));
		result.setTotalCount(mapper.getByCriteriaCount(criteria));
		
		return result;
	}

	public UserMapper getMapper() {
		return mapper;
	}

	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
}
