package ty.pms.service.user;

import java.util.List;

import ty.pms.model.user.User;

public interface UserService {
	/*
	String deleteByPrimaryKey(String id);

	String insert(User record);

	String insertSelective(User record);

    User selectByPrimaryKey(String id);

    String updateByPrimaryKeySelective(User record);

    String updateByPrimaryKey(User record);
   */
	User selectByPrimaryKey(String name);
	User selectUserByName(String name);
	List<User> getAll();
}
