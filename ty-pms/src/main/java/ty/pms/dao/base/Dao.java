package ty.pms.dao.base;

import java.util.List;

public interface Dao <T,C>{
	/**
	 * 
	 * @param record
	 * @return
	 */
	Integer insertSelective(T record);
	
	 /**
     * 
     * @param record
     * @return 更新的行数
     */
    Integer updateByPrimaryKeySelective(T record);
    
    
	/**
	 * @param id
	 * @return 删除的行数
	 */
    Integer deleteByPrimaryKey(String id);

    /**
     * 
     * @param id
     * @return
     */
	T selectByPrimaryKey(String id);
    
	/**
	 * 
	 * @param name
	 * @return
	 */
	T selectByName(String name);
    
	/**
	 * 
	 * @return
	 */
    List<T> getAll();
    Integer getAllCount();
	
    /**
     * 
     * @param criteria
     * @return
     */
    List<T> getByCriteria(C criteria); 
    Integer getByCriteriaCount(C criteria);
	
}
