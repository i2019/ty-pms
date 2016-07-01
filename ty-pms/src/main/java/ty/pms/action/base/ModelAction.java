package ty.pms.action.base;

import ty.pms.action.base.BaseAction;

public class ModelAction extends BaseAction{

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
		
		return "edit";
	}
	/**
	 * 删除
	 * @return
	 */
	public String del(){
		
				
		return list();
	}
	/**
	 * 新增或者编辑保存
	 * @return
	 */
	public String save(){
	
		return "list";
	}

	public void ajaxVerifyOnly(){
		
	}
	
	
}
