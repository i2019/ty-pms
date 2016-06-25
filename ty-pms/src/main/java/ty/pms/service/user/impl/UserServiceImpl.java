package ty.pms.service.user.impl;

import java.util.Date;

import ty.pms.dao.user.UserMapper;
import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;
import ty.pms.service.base.BaseService;
import ty.pms.service.user.UserService;
import ty.pms.util.CommonUtil;

public class UserServiceImpl extends BaseService implements UserService {
	
	private UserMapper userMapper;

	private User loginUser=null;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	/**
	 * 根据用户id获取用户对象
	 */
	@Override
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	/**
	 * 根据用户名获取用户对象
	 */
	@Override
	public User selectUserByName(String name) {
		return userMapper.selectUserByName(name);
	}
	
	/*
	 * 获取所有对象
	 */
	public UserResult getAll(){
		UserResult userResult=new UserResult();

		userResult.setResultList(userMapper.getAll());
		userResult.setTotalCount(userMapper.getAllCount());
		
		return userResult;
	}
	
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
		
		return userMapper.insertSelective(record);
	}
	
	/**
	 * 根据用户id更新用户信息,返回影响的行数
	 */
	@Override
	public Integer updateByPrimaryKeySelective(User record){
		return userMapper.updateByPrimaryKeySelective(record);
	}
	
	public Integer deleteByPrimaryKey(String id){
		return userMapper.deleteByPrimaryKey(id);
	}
	
	public UserResult getUsers(UserCriteria criteria){
		UserResult userResult=new UserResult();
		
		userResult.setResultList(userMapper.getUsers(criteria));
		userResult.setTotalCount(userMapper.getUsersCount(criteria));
		
		return userResult;
	}
	
	
}
