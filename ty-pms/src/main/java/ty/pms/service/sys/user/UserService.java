package ty.pms.service.sys.user;

import java.util.List;

import ty.pms.model.sys.user.User;
import ty.pms.model.sys.user.UserCriteria;
import ty.pms.model.sys.user.UserResult;
import ty.pms.service.base.Service;

public interface UserService extends Service<User, UserResult, UserCriteria>{
	List<String> getUserNameList();
}
