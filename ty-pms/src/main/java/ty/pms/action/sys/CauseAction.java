package ty.pms.action.sys;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import ty.pms.action.base.BaseAction;
import ty.pms.model.common.cause.Cause;
import ty.pms.model.common.cause.CauseCriteria;
import ty.pms.model.common.cause.CauseResult;
import ty.pms.service.common.cause.CauseService;
import ty.pms.util.Constants;

public class CauseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2213262590709584140L;

	@Autowired
	private CauseService causeService;
	private CauseResult causeResult=new CauseResult();
	private List<Cause> causeList=new ArrayList<Cause>();
	private CauseCriteria causeCriteria=new CauseCriteria();
	private Cause cause;
	private String causeId;
	private List<Integer> causeTypeList=new ArrayList<Integer>(); 
	/**
	 * 查询并展示
	 * 
	 * @return
	 */
	public String list() {
		// displaytag 分页
		int pageSize = this.getCurrentPageSize("day2DayList");
		int pageNo = this.getCurrentPageNo("day2DayList");
		causeCriteria.setPageNum(pageNo);
		causeCriteria.setPageSize(pageSize);

		if (!StringUtils.hasText(causeCriteria.getRemark())) {
			causeCriteria.setRemark(null);
		}
		
		causeResult = causeService.getByCriteria(causeCriteria);
		
		init();
		
		return "list";
	}
	/**
	 * 初始化查询条件
	 */
	public void init(){
		//原因
		causeResult=causeService.getByCriteria(causeCriteria);
		if(null!=causeResult){
			causeList=causeResult.getResultList();
		}
		
		//原因类别
		causeTypeList.add(Constants.CauseType_1);
		causeTypeList.add(Constants.CauseType_2);
		causeTypeList.add(Constants.CauseType_3);
	}
	/**
	 * 编辑或新增
	 * 
	 * @return
	 */
	public String edit() {
		init();
		if(StringUtils.hasText(causeId)){
			cause=causeService.selectByPrimaryKey(causeId);
		}
		return "edit";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String del() {
		if(StringUtils.hasText(causeId)){
			Cause record=causeService.selectByPrimaryKey(causeId);
			if(null!=record && causeId.equals(record.getCauseId())){
				record.setDelFlag(true);
				causeService.updateByPrimaryKeySelective(record);
				//causeService.deleteByPrimaryKey(causeId);
			}
		}
		return list();
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		if(null!=cause ){	
			//如果存在用户id，则为编辑，后台update
			if(StringUtils.hasText(cause.getCauseId())){
				causeService.updateByPrimaryKeySelective(cause);
			}else{
			//如果不存在id，则为新增，后台insert
				causeService.insertSelective(cause);
			}
		}
		return "list";
	}
	
	public List<Integer> getCauseTypeList() {
		return causeTypeList;
	}
	public void setCauseTypeList(List<Integer> causeTypeList) {
		this.causeTypeList = causeTypeList;
	}
	public CauseResult getCauseResult() {
		return causeResult;
	}
	public void setCauseResult(CauseResult causeResult) {
		this.causeResult = causeResult;
	}
	public List<Cause> getCauseList() {
		return causeList;
	}
	public void setCauseList(List<Cause> causeList) {
		this.causeList = causeList;
	}
	public CauseCriteria getCauseCriteria() {
		return causeCriteria;
	}
	public void setCauseCriteria(CauseCriteria causeCriteria) {
		this.causeCriteria = causeCriteria;
	}
	public Cause getCause() {
		return cause;
	}
	public void setCause(Cause cause) {
		this.cause = cause;
	}
	public String getCauseId() {
		return causeId;
	}
	public void setCauseId(String causeId) {
		this.causeId = causeId;
	}

}
