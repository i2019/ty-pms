package ty.pms.action.time;

import ty.pms.action.base.BaseAction;


public class Day2DayAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3493242442228871033L;
	/**
	 * 查询并展示
	 * @return
	 */
	public String list() {
		return "list";
		
	}
	/**
	 * 编辑或新增
	 * @return
	 */
	public String edit(){
		return list(); 
	}
	/**
	 * 删除
	 * @return
	 */
	public String del(){
		
				
		return list();
	}
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		
		return "list";
	}
	
}
