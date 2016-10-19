package ty.pms.action.account;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ty.pms.action.base.BaseAction;
import ty.pms.model.account.expenditure.Expenditure;
import ty.pms.model.account.expenditure.ExpenditureCriteria;
import ty.pms.model.account.expenditure.ExpenditureResult;
import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.model.sys.user.UserResult;
import ty.pms.service.account.expenditure.ExpenditureService;
import ty.pms.service.sys.user.UserService;

public class ExpenditureAction extends BaseAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1893817493888847014L;

	private Log log = LogFactory.getLog(ExpenditureAction.class);
	
	@Autowired
	private UserService userService;
	private List<String> userNameList=new ArrayList<String>();
	private User loginUser;
  
    @Autowired 
    private ExpenditureService expenditureService;
    private String expenditureId;
	private Expenditure expenditure;
	private ExpenditureCriteria expenditureCriteria=new ExpenditureCriteria();
	private ExpenditureResult expenditureResult=new ExpenditureResult();
	private List<Expenditure> expenditureList=new ArrayList<Expenditure>();
    
	/**
	 * 查询并展示
	 * @return
	 */
	public String list() {
		
		loginUser=getLoginUser();
		
		//displaytag 分页
		int pageSize = this.getCurrentPageSize("userList");
		int pageNo = this.getCurrentPageNo("userList");
		expenditureCriteria.setPageNum(pageNo);
		expenditureCriteria.setPageSize(pageSize);

		if(!StringUtils.hasText(expenditureCriteria.getRemark())){
			expenditureCriteria.setRemark(null);
		}
		
		expenditureResult=expenditureService.getByCriteria(expenditureCriteria);
		
		//查询条件
		userNameList=userService.getUserNameList();
		
		return "list";
		
	}
	/**
	 * 编辑或新增
	 * @return
	 */
	public String edit(){
		if(StringUtils.hasText(expenditureId)){
			expenditure=expenditureService.selectByPrimaryKey(expenditureId);	
		}
		return "edit";
	}
	/**
	 * 删除
	 * @return
	 */
	public String del(){
		loginUser=getLoginUser();
		if(StringUtils.hasText(expenditureId) && null!=loginUser){
			expenditureService.deleteByPrimaryKey(expenditureId);
		}
		
		return list();
	}
	/**
	 * 新增或者编辑保存
	 * @return
	 */
	public String save(){
		if(null!=expenditure ){	
			//如果存在用户id，则为编辑，后台update
			if(StringUtils.hasText(expenditure.getExpenditureId())){
				expenditureService.updateByPrimaryKeySelective(expenditure);
			}else{
			//如果不存在id，则为新增，后台insert
				expenditureService.insertSelective(expenditure);
			}
		}
		return "list";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<String> getUserNameList() {
		return userNameList;
	}
	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}
	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public ExpenditureService getExpenditureService() {
		return expenditureService;
	}
	public void setExpenditureService(ExpenditureService expenditureService) {
		this.expenditureService = expenditureService;
	}
	public String getExpenditureId() {
		return expenditureId;
	}
	public void setExpenditureId(String expenditureId) {
		this.expenditureId = expenditureId;
	}
	public Expenditure getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(Expenditure expenditure) {
		this.expenditure = expenditure;
	}
	public ExpenditureCriteria getExpenditureCriteria() {
		return expenditureCriteria;
	}
	public void setExpenditureCriteria(ExpenditureCriteria expenditureCriteria) {
		this.expenditureCriteria = expenditureCriteria;
	}
	public ExpenditureResult getExpenditureResult() {
		return expenditureResult;
	}
	public void setExpenditureResult(ExpenditureResult expenditureResult) {
		this.expenditureResult = expenditureResult;
	}
	public List<Expenditure> getExpenditureList() {
		return expenditureList;
	}
	public void setExpenditureList(List<Expenditure> expenditureList) {
		this.expenditureList = expenditureList;
	}
	
}
