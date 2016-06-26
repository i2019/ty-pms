package ty.pms.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthorizationInterceptor implements Interceptor {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 8106268850801377123L;

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//只有登录用户才可以查看的拦截器
		Map session = ai.getInvocationContext().getSession();
	    String userName = (String) session.get("LoginUserName");
	     if(null != userName){
	        return ai.invoke();
	    } else {
	        return Action.LOGIN;
	    }        
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
}
