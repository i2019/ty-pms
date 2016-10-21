package ty.pms.util.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @源码作者:刘夕波
 * @创建日期:Mar 17, 2009
 * @当前版本:V 1.0 MD5的算法在RFC1321 中定义 在RFC 1321中，给出了Test suite用来检验你的实现是否正确： MD5 ("")
 *         =d41d8cd98f00b204e9800998ecf8427e MD5 ("a")
 *         =0cc175b9c0f1b6a831c399e269772661 MD5 ("abc")
 *         =900150983cd24fb0d6963f7d28e17f72 MD5 ("message digest")
 *         =f96b697d7cb7938d525a2f31aaf161d0 MD5 ("abcdefghijklmnopqrstuvwxyz")
 *         =c3fcd3d76192e4007dfb496cca67e13b 传入参数：一个字节数组 传出参数：字节数组的 MD5 结果字符串
 */
public class MD5 {

	/**
	 * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
	 */
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	protected static MessageDigest messagedigest = null;
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static String getMD5(String source){
		try {
			return getMD5(source.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UnsupportedEncodingException error!");
		}
	}
	
	
	public static String getMD5(byte[] source) {
		String s = null;

		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String getMD5(File file) {
		InputStream fis=null;
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			
			fis = new FileInputStream(file);
			//BufferedInputStream buf=new BufferedInputStream(fis);
			byte[] buffer = new byte[524288];
			int numRead = 0;
			while ((numRead = fis.read(buffer)) > 0) {
				md.update(buffer, 0, numRead);
			}
			//buf.close();
			return bufferToHex(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					// noop
				}
			}
		}
	}

	public static String getMD5(java.nio.ByteBuffer buff) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(buff.array(),0,buff.position());
			return bufferToHex(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换
		// 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
		char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static void main(String[] args) {
		// 计算 "a" 的 MD5 代码，应该为：0cc175b9c0f1b6a831c399e269772661
		//System.out.println(getMD5("111111".getBytes()));
		/*Long startTime = (new Date().getTime());
		File file = new File("F:\\backup\\G31-ghost.GHO");

		System.out.println("md5=" + MD5_big.getMD5(file));
		Long endTime = (new Date().getTime());
		System.out.println(endTime - startTime);*/
		//unid$code$name$unit
		// 62$030404032001$接线端子箱$		a3c326d7467121e9a702e11f5069ddbe
		// 62$030904009001$楼层显示盘$		357b775b2b429262c735108d0dff818e
		System.out.println(MD5.getMD5("62$030404032001$接线端子箱$".getBytes()));
		System.out.println("a3c326d7467121e9a702e11f5069ddbe");
		System.out.println(MD5.getMD5("62$030904009001$楼层显示盘$".getBytes()));
		System.out.println("357b775b2b429262c735108d0dff818e");
	}

}
