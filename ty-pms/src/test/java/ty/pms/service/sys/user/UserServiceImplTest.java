package ty.pms.service.sys.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.model.sys.user.UserResult;
import ty.pms.service.sys.user.UserService;
import ty.pms.test.base.BaseTest;
import ty.pms.util.CommonUtil;

public class UserServiceImplTest  extends BaseTest<UserService> {

	private static UserService userService;
	
	@Before
	public void setUp() throws Exception {
		userService = init("userService");
	}
	
	//@Test
	public void testSelectByPrimaryKey() {
		User u = userService.selectByName("k");
		System.out.println(u);
		Assert.assertEquals("k", u.getUserName());
	}

	//@Test
	public void testSelectUserByName() {
		
	}

	private void createRecords(Integer i){
		while(i>1){
			User record=new User();
			record.setUserId(CommonUtil.generateUUID());
			record.setUserName(CommonUtil.generateUUID().substring(27));
			userService.insertSelective(record);
			i--;
		}
	}
	
	@Test
	public void testGetUsers() {
		
		//createRecords(30);
		
		UserCriteria c=new UserCriteria();
		
		//c.setSkipResults(20);
		
		List<String> ns=new ArrayList<String>();
		ns.add("t");
		ns.add("k");
		ns.add("2");
		ns.add("7");
		//c.setUserNameList(ns);
		
		//c.setCreatedTimeBegin(new Date());
		Date d=new Date();
		d.setTime(System.currentTimeMillis());
		//c.setCreatedTimeEnd(d);
		
		UserResult r=new UserResult();
		r=userService.getByCriteria(c);
		
		System.out.println("结果数："+r.getTotalCount());
		
		List<User> us=r.getResultList();
		System.out.println("查询数："+us.size());
		
		for (User u : us) {
			System.out.println(u+"-------"+u.getCreatedTime());
		}
		
	}

}
