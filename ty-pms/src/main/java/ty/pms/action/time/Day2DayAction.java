package ty.pms.action.time;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import ty.pms.action.base.BaseAction;
import ty.pms.model.common.cause.Cause;
import ty.pms.model.common.cause.CauseCriteria;
import ty.pms.model.common.cause.CauseResult;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserResult;
import ty.pms.model.time.day2day.Day2Day;
import ty.pms.model.time.day2day.Day2DayCriteria;
import ty.pms.model.time.day2day.Day2DayResult;
import ty.pms.service.common.cause.CauseService;
import ty.pms.service.sys.user.UserService;
import ty.pms.service.time.day2day.Day2DayService;
import ty.pms.util.Constants;

public class Day2DayAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3493242442228871033L;

	@Autowired
	private Day2DayService day2DayService;
	private Day2DayCriteria day2DayCriteria=new Day2DayCriteria();
	private Day2DayResult day2DayResult = new Day2DayResult();
	private String d2Id;
	private Day2Day day2Day;
	
	@Autowired
	private UserService userService;
	private User loginUser;
	private List<User> userList=new ArrayList<User>();
	private List<String> ownerList=new ArrayList<String>();
	private UserResult userResult=new UserResult(); 
	

	@Autowired
	private CauseService causeService;
	private CauseResult causeResult=new CauseResult();
	private List<Cause> causeList=new ArrayList<Cause>();
	private CauseCriteria causeCriteria=new CauseCriteria();
	
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
		if(!StringUtils.hasText(day2DayCriteria.getD2Descrip())){
			day2DayCriteria.setD2Descrip(null);
		}

		day2DayResult = day2DayService.getByCriteria(day2DayCriteria);
	
		init();
		
		return "list";
	}
	/**
	 * 初始化查询条件
	 */
	public void init(){
		//用户
		//ownerList=userService.getUserNameList();
		userResult=userService.getAll();
		if(null!=userResult){
			userList=userResult.getResultList();
		}
		
		//原因
		causeCriteria.setCauseType(Constants.CauseType_3);
		causeResult=causeService.getByCriteria(causeCriteria);
		if(null!=causeResult){
			causeList=causeResult.getResultList();
		}
	}
	/**
	 * 编辑或新增
	 * 
	 * @return
	 */
	public String edit() {
		loginUser=getLoginUser();
		if(null!=loginUser){
			init();
			day2Day=day2DayService.selectByPrimaryKey(d2Id);
			return "edit";
		}
		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String del() {
		loginUser=getLoginUser();
		if(StringUtils.hasText(d2Id) && null!=loginUser){
			day2DayService.deleteByPrimaryKey(d2Id);
		}
		return list();
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		if(null!=day2Day ){	
			//如果存在用户id，则为编辑，后台update
			if(StringUtils.hasText(day2Day.getD2Id())){
				day2DayService.updateByPrimaryKeySelective(day2Day);
			}else{
			//如果不存在id，则为新增，后台insert
				day2DayService.insertSelective(day2Day);
			}
		}
		return "list";
	}

	public String getD2Id() {
		return d2Id;
	}

	public void setD2Id(String d2Id) {
		this.d2Id = d2Id;
	}

	public Day2DayService getDay2DayService() {
		return day2DayService;
	}

	public Day2Day getDay2Day() {
		return day2Day;
	}

	public void setDay2Day(Day2Day day2Day) {
		this.day2Day = day2Day;
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
	public List<String> getOwnerList() {
		return ownerList;
	}

	public void setOwnerList(List<String> ownerList) {
		this.ownerList = ownerList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Cause> getCauseList() {
		return causeList;
	}
	public void setCauseList(List<Cause> causeList) {
		this.causeList = causeList;
	}

}
