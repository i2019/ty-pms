package ty.pms.dao.user;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;
import ty.pms.test.base.BaseTest;

public class UserMapperTest extends BaseTest<UserMapper> {

	
	private static UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
		userMapper = init("userMapper");
	}

	//@Test
	public void testDeleteByPrimaryKey() {
		Integer id=userMapper.deleteByPrimaryKey("1");
		System.out.println(id);
		assertEquals(new Integer(1), id);
	}
	/*
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}
	 */
	//@Test
	public void testInsertSelective() {
		User c=new User();
		c.setUserId("y");
		c.setCreatedTime(new Date());
		c.setUserName("0");
		
		userMapper.insertSelective(c);
	}
	
	//@Test
	public void testUpdateByPrimaryKeySelective() {
		User c=new User();
		c.setUserId("1");
		c.setCreatedTime(new Date());
		
		userMapper.updateByPrimaryKeySelective(c);
	}
	
	//@Test
	public void testUpdateByPrimaryKey() {
		User c=new User();
		c.setCreatedTime(new Date());
		
		userMapper.updateByPrimaryKeySelective(c);
	}

	//@Test
	public void testSelectByPrimaryKey() {
		User user = userMapper.selectByPrimaryKey("1");
		Assert.assertEquals("b", user.getUserName());
	}

	/*@Test
	public void testSelectUserByName() {
		fail("Not yet implemented");
	}
	 */
	@Test
	public void testGetUsers() {

		List<User> us=userMapper.getUsers(new UserCriteria());
		for (User u : us) {
			System.out.println(u+"-------"+u.getCreatedTime());
		}
	}

}
