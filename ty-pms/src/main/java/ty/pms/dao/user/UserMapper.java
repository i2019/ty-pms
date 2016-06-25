package ty.pms.dao.user;

import java.util.List;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;

public interface UserMapper {
	
	/*------使用中begin--------------------*/
	
	void insertSelective(UserCriteria record);
	
	UserCriteria selectByPrimaryKey(String id);
    
	UserCriteria selectUserByName(String name);
    
    List<User> getAll();
    Integer getAllCount();
	
    Integer deleteByPrimaryKey(String id);

    String updateByPrimaryKeySelective(UserCriteria record);

	/*------使用中end----------------------*/
	
	
	String insert(UserCriteria record);

    String updateByPrimaryKey(UserCriteria record);
  
}