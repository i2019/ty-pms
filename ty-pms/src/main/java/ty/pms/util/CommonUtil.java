package ty.pms.util;

import java.util.UUID;

public class CommonUtil {
	/**
	 * 产生UUIDD
	 * 
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
