package ty.pms.service.user.impl;

import java.util.Date;
import java.util.List;

import ty.pms.dao.user.UserMapper;
import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
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
	public List<User> getAll(){
		return userMapper.getAll();
	}
	
	/**
	 * 插入新纪录（不为空的字段）
	 */
	@Override
	public void insertSelective(UserCriteria record) {
		
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
		
		userMapper.insertSelective(record);
	}
	
}
