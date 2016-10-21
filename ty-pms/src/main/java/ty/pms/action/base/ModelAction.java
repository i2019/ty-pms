package ty.pms.action.base;

public class ModelAction extends BaseAction{

	private static final long serialVersionUID = 1L;

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
