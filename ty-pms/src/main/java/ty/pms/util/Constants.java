package ty.pms.util;

/**
 * Constant values used throughout the application.
 */
public final class Constants {

	private Constants() {
		// hide me
	}

	// ====================== Static fields/initializers =======================
	
	// int类型的值在一些版本JDK下会生成int PAGE_SIZE = null的错误 jsp类文件，以致页面打开编译报错
	// public static final int PAGE_SIZE = 20;
	public static final Integer PAGE_SIZE = 20;
	
}
