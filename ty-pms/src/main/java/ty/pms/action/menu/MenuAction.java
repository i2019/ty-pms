package ty.pms.action.menu;

import ty.pms.action.base.BaseAction;

public class MenuAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4342238361948652445L;

	private String menu;
	
	/**
	 * 查询并展示
	 * @return
	 */
	public String list() {
		
		menu=getRequest().getParameter("menu");
		System.out.println(menu);
		
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
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
