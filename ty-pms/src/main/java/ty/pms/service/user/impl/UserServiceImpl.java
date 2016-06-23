package ty.pms.service.user.impl;

import java.util.List;

import ty.pms.dao.user.UserMapper;
import ty.pms.model.user.User;
import ty.pms.service.user.UserService;

public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

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
}
