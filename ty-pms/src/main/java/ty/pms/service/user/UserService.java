package ty.pms.service.user;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;

public interface UserService {

	/*------使用中begin--------------------*/
	
	void insertSelective(UserCriteria record);
	
	UserCriteria selectByPrimaryKey(String id);
	UserCriteria selectUserByName(String name);
	UserResult getAll();
	/*
	 * 根据用户id更新用户信息
	 * */
	String updateByPrimaryKeySelective(UserCriteria record);
	
	Integer deleteByPrimaryKey(String id);
	/*------使用中end----------------------*/

}
