package ty.pms.dao.user;

import java.util.List;

import ty.pms.model.user.User;

public interface UserMapper {
	String deleteByPrimaryKey(String id);

	String insert(User record);

	String insertSelective(User record);

    String updateByPrimaryKeySelective(User record);

    String updateByPrimaryKey(User record);
    
    User selectByPrimaryKey(String id);
    
    User selectUserByName(String name);
    
    List<User> getAll();
}