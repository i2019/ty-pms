package ty.pms.service.user;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;

public interface UserService {

	/*------使用中begin--------------------*/
	
	Integer insertSelective(User record);
	
	/*
	 * 根据用户id更新用户信息,返回影响的行数
	 * */
	Integer updateByPrimaryKeySelective(User record);
	
	Integer deleteByPrimaryKey(String id);
	
	
	User selectByPrimaryKey(String id);
	
	User selectUserByName(String name);
	
	UserResult getAll();
	
	UserResult getUsers(UserCriteria criteria);
	
	/*------使用中end----------------------*/

}
