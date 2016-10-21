package ty.pms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ty.pms.model.account.expenditure.Expenditure;

/**
 * 导入以前没有系统时记录在有道云笔记上的消费记录
 * 
 * @author 钟燕
 * @date 2016-10-20
 */
public class ImpOldExpendData {
	public static void main(String[] args) throws Exception {
		new ImpOldExpendData().imp("test22.txt");
	}
	
	/**
	 * 导入
	 * @author 钟燕 2016年10月20日 下午4:18:19
	 * @version 1.0
	 * @throws Exception 
	 */
	public List<Expenditure> imp(String filePath) throws Exception {
			List<Expenditure> results = new ArrayList<Expenditure>();
			String content = readFileAsString(filePath);
			
			// 存一天的多条消费记录
			String[] oneDays = content.toString().split("&");
			// 存具体的一条消费记录
			String[] oneData;		// ["日期", "名字","钱数"]
			String[] one;	// ["名字","钱数"]
			Expenditure oneExp = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date aDay;
			for (int i = 0; i < oneDays.length; i++) {
				oneData = oneDays[i].split("#");
				aDay = sdf.parse(convertDate(oneData[0]));
				for (int j = 0; j < oneData.length; j++) {
					if(!oneData[j].equals("")) {
						one = oneData[j].split(" ");
						if(one.length >= 2) {	// 是有效数据
							oneExp = new Expenditure();
							results.add(oneExp);
							oneExp.setOccurrencedTime(aDay);
							for (int j2 = 0; j2 < one.length; j2++) {
								if(!one[j2].equals("")) {
									if(oneExp.getRemark() == null) {
										oneExp.setRemark(one[j2]);
									} else { 
										oneExp.setExpenditureAmount(new BigDecimal(one[j2]));
									}
								}
							}
						}
					}
				}
			}
			
		/*	for (int i = 0; i < results.size(); i++) {
				Expenditure data = results.get(i);
				System.out.println(data.getOccurrencedTime()+"\t"+data.getRemark()+"\t"+data.getExpenditureAmount());
			}*/
			
			
			return results;
	}
	
	/** 
	 * 读取文件 作为字符串返回
	 * 返回字符串格式： &为间隔一天  #为间隔一条消费 空格为间隔一条消费的原因和钱数
	 * @param filePath
	 * @return
	 * @throws Exception
	 * @author 钟燕 2016年10月20日 下午6:30:48
	 * @version 1.0
	 */
	private String readFileAsString(String filePath) throws Exception {
		String encoding = "UTF-8";
		File file = new File(filePath);
		if (!file.isFile() || !file.exists()) {	// 判断文件是否存在
			System.out.println(file.getAbsolutePath() + "/t找不到指定的文件");
			return "";
		}
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
		BufferedReader bufferedReader = new BufferedReader(read);
		// 用来拼接文本内容   &为间隔一天  #为间隔一条消费 空格为间隔一条消费的原因和钱数
		StringBuffer content = new StringBuffer();
		String lineTxt = null;
		String[] temp;
		int index = 0;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			lineTxt = lineTxt.trim();
			temp = lineTxt.split(" ");
			if(lineTxt.length() == 8 && lineTxt.startsWith("201") && temp.length == 1 && index != 0) {	// lineTxt是日期
				content.append("&");
			}
			content.append(lineTxt);
			content.append("#");
			index++;
		}
		read.close();
		return content.toString();
	}
	
	/** 
	 * 把yyyyMMdd格式的日期转换为yyyy-MM-dd格式的日期
	 * @param oldDate
	 * @return
	 * @author 钟燕 2016年10月20日 下午5:49:21
	 * @version 1.0
	 */
	public String convertDate(String oldDate) {
		String result = null;
		if(oldDate.length() == 8 && oldDate.startsWith("201")) {	// 是正确的数据格式
			result = oldDate.substring(0, 4) + "-" + oldDate.substring(4, 6) + "-" + oldDate.substring(6);
		}
		return result;
	}
}
