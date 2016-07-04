package ty.pms.action.time;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import ty.pms.action.base.BaseAction;
import ty.pms.model.sys.user.User;
import ty.pms.model.time.day2day.Day2DayCriteria;
import ty.pms.model.time.day2day.Day2DayResult;
import ty.pms.service.sys.user.UserService;
import ty.pms.service.time.day2day.Day2DayService;

public class Day2DayAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3493242442228871033L;

	@Autowired
	private Day2DayService day2DayService;
	@Autowired
	private UserService userService;
	
	private Day2DayCriteria day2DayCriteria=new Day2DayCriteria();
	private Day2DayResult day2DayResult = new Day2DayResult();

	private List<User> userList=new ArrayList<User>();
	private List<String> userNameList=new ArrayList<String>();
	
	/**
	 * 查询并展示
	 * 
	 * @return
	 */
	public String list() {

		// displaytag 分页
		int pageSize = this.getCurrentPageSize("day2DayList");
		int pageNo = this.getCurrentPageNo("day2DayList");
		day2DayCriteria.setPageNum(pageNo);
		day2DayCriteria.setPageSize(pageSize);

		if (!StringUtils.hasText(day2DayCriteria.getRemark())) {
			day2DayCriteria.setRemark(null);
		}

		day2DayResult = day2DayService.getByCriteria(day2DayCriteria);
		
		//查询条件
		userNameList=userService.getUserNameList();
				
		
		return "list";
	}

	/**
	 * 编辑或新增
	 * 
	 * @return
	 */
	public String edit() {
		return list();
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String del() {

		return list();
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {

		return "list";
	}

	public Day2DayService getDay2DayService() {
		return day2DayService;
	}

	public void setDay2DayService(Day2DayService day2DayService) {
		this.day2DayService = day2DayService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Day2DayCriteria getDay2DayCriteria() {
		return day2DayCriteria;
	}

	public void setDay2DayCriteria(Day2DayCriteria day2DayCriteria) {
		this.day2DayCriteria = day2DayCriteria;
	}

	public Day2DayResult getDay2DayResult() {
		return day2DayResult;
	}

	public void setDay2DayResult(Day2DayResult day2DayResult) {
		this.day2DayResult = day2DayResult;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<String> getUserNameList() {
		return userNameList;
	}

	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
