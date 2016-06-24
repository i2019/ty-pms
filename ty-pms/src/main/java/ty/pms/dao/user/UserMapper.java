package ty.pms.dao.user;

import java.util.List;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;

public interface UserMapper {
	
	
	/*------使用中begin--------------------*/
	
	
	void insertSelective(UserCriteria record);
	
	User selectByPrimaryKey(String id);
    
    User selectUserByName(String name);
    
    List<User> getAll();
	
	/*------使用中end----------------------*/
	
	
	String insert(UserCriteria record);

	String deleteByPrimaryKey(String id);

    String updateByPrimaryKeySelective(User record);

    String updateByPrimaryKey(User record);
  
}