package ty.pms.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.user.User;
import ty.pms.model.user.UserCriteria;
import ty.pms.model.user.UserResult;
import ty.pms.service.user.UserService;
import ty.pms.test.base.BaseTest;

public class UserServiceImplTest  extends BaseTest<UserService> {

	private static UserService userService;
	
	@Before
	public void setUp() throws Exception {
		userService = init("userService");
	}

	/*@Test
	public void testGetUserMapper() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserMapper() {
		fail("Not yet implemented");
	}*/

	//@Test
	public void testSelectByPrimaryKey() {
		User u = userService.selectUserByName("p");
		System.out.println(u);
		Assert.assertEquals("p", u.getUserName());
	}

	//@Test
	public void testSelectUserByName() {
		
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetUsers() {
		UserCriteria c=new UserCriteria();
		
		List<String> ns=new ArrayList<String>();
		ns.add("t");
		ns.add("0");
		ns.add("2");
		ns.add("7");
		c.setUserNameList(ns);
		
		//c.setCreatedTimeBegin(new Date());
		Date d=new Date();
		d.setTime(System.currentTimeMillis());
		c.setCreatedTimeEnd(d);
		
		UserResult r=new UserResult();
		r=userService.getUsers(c);
		
		System.out.println("结果数："+r.getTotalCount());
		List<User> us=r.getResultList();
		for (User u : us) {
			System.out.println(u+"-------"+u.getCreatedTime());
		}
		
	}

}
