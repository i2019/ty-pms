/**
 * 
 */
package ty.pms.model.base;

import java.io.Serializable;
import java.util.Date;

public class SearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2169539668297860191L;

	public static final String DESC = "desc";
	public static final String ASC = "asc";

	private Integer pageSize = 20;// 每页大小,default 20
	private Integer pageNum = 1;// 当前页,从0开始
	private Integer total = 0; // 记录总数
	private Integer start = 0; // 开始
	private String sortBy;// 参见子类的说明

	private String desc = ASC;
	
	private boolean isNeedPage = true;// 是否需要分页标志,默认是需要分页
	@SuppressWarnings("unused")
	private Integer maxResults;
	private Integer skipResults;
	
	public Integer getSkipResults() {
		if (isNeedPage) {
			return (getPageNum() - 1) * getPageSize();
		} else {
			return skipResults;
		}
	}
	
	public void setSkipResults(Integer skipResults) {
		this.skipResults = skipResults;
	}

	public Integer getMaxResults() {
		return this.getPageSize();
	}
	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNum
	 */
	public Integer getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum
	 *            the pageNum to set
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy
	 *            the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal() {
		return total;
	}

	public boolean isNeedPage() {
		return isNeedPage;
	}

	public void setNeedPage(boolean isNeedPage) {
		this.isNeedPage = isNeedPage;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	// need pageNum, total, pageSize to calc start
	public Integer getStart() {

		if (pageNum <= 1) {
			return 0;
		}
		if (total > 0) {
			int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

			if (pageNum >= totalPage) {
				pageNum = totalPage;
			}
		}

		return (pageNum - 1) * pageSize;
	}

	@Override
	public String toString() {
		return "SearchCriteria [desc=" + desc + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", sortBy=" + sortBy + ", start=" + start + ", total=" + total + "]";
	}
	
	/**
	 * 共有字段
	 */
	 private Date occurrencedTime;//发生时间
	 private Date endTime;//结束时间
	 private String owner;//所有者
	 private Date createdTime;//创建时间
	 private Date lastModifyTime;//修改时间
     private String createdBy;//创建者
     private String updatedBy;//修改者
     private String remark;//备注
     private boolean delFlag;//删除标志
   
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getOccurrencedTime() {
		return occurrencedTime;
	}
	public void setOccurrencedTime(Date occurrencedTime) {
		this.occurrencedTime = occurrencedTime;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isDelFlag() {
		return delFlag;
	}
	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}
     
}
