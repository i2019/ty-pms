package ty.pms.dao.user;

import java.util.List;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;

public interface UserMapper {
	
	/*------使用中begin--------------------*/
	
	Integer insertSelective(User record);
	
	 /**
     * 
     * @param record
     * @return 更新的行数
     */
    Integer updateByPrimaryKeySelective(User record);
    
    
	/**
	 * @param id
	 * @return 删除的行数
	 */
    Integer deleteByPrimaryKey(String id);

    
	User selectByPrimaryKey(String id);
    
	User selectUserByName(String name);
    
	
    List<User> getAll();
    
    Integer getAllCount();
	
    
    List<User> getUsers(UserCriteria criteria);
    
    Integer getUsersCount(UserCriteria criteria);
    
	/*------使用中end----------------------*/
    
	/**
	 * 
	 * @param record
	 * @return 
	 */
    Integer insert(User record);
	
	/**
	 * 
	 * @param record
	 * @return 更新的行数
	 */
    Integer updateByPrimaryKey(User record);
  
}