package ty.pms.service.base;

import java.util.List;

public interface Service <T,R,C>{
	
	Integer insertSelective(T record);
	
	Integer updateByPrimaryKeySelective(T record);
	
	Integer deleteByPrimaryKey(String id);
		
	T selectByPrimaryKey(String id);
	
	List<T> selectByName(String name);
	
	R getAll();
	
	R getByCriteria(C criteria);

}
