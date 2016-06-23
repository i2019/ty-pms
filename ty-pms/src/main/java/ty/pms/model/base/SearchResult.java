/**
 *
 */
package ty.pms.model.base;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchResult<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8744201707127453267L;
    private Integer totalCount = 0;//总共多少记录
    private List<T> resultList = new ArrayList<T>();

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    /**
     * @return the totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    
    @Override
    public String toString() {
        return "[resultList=" + resultList + "]";
    }
}
