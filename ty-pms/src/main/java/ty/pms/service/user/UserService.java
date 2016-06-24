package ty.pms.service.user;

import java.util.List;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;

public interface UserService {

	/*------使用中begin--------------------*/
	
	
	void insertSelective(UserCriteria record);
	
	
	/*------使用中end----------------------*/
	
	User selectByPrimaryKey(String name);
	User selectUserByName(String name);
	List<User> getAll();
}
