package ty.pms.service.base;

public interface Service <T,R,C>{
	
	Integer insertSelective(T record);
	
	Integer updateByPrimaryKeySelective(T record);
	
	Integer deleteByPrimaryKey(String id);
		
	T selectByPrimaryKey(String id);
	
	T selectByName(String name);
	
	R getAll();
	
	R getByCriteria(C criteria);

}
