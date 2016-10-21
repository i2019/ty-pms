package ty.pms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ty.pms.model.account.expenditure.Expenditure;
import ty.pms.model.account.income.Income;
import ty.pms.model.base.BaseObject;

/**
 * 导入以前没有系统时记录在有道云笔记上的消费记录
 * 
 * @author 钟燕
 * @date 2016-10-20
 */
public class ImpOldExpendData {
	public static void main(String[] args) throws Exception {
		ImpOldExpendData.importFile("test22.txt");
	}
	
	/** 
	 * 通过固定文件格式来解析内容 并作为消费或支出记录存到集合中
	 * @param filePath 文件路径
	 * @return Map<Integer,List<Object>>	<br>
	 * 			Map.get(1)	消费记录
	 * 			Map.get(1)	收入记录
	 * @throws Exception
	 * @author 钟燕 2016年10月21日 上午10:56:00
	 * @version 1.0
	 */
	public static Map<Integer,List<Object>> importFile(String filePath) throws Exception {
		List<Object> exps = new ArrayList<Object>();
		List<Object> incomes = new ArrayList<Object>();
		Map<Integer,List<Object>> results = new HashMap<Integer,List<Object>>();
		results.put(new Integer(1), exps);
		results.put(new Integer(2), incomes);
		
		String encoding = "UTF-8";
		File file = new File(filePath);
		if (!file.isFile() || !file.exists()) {	// 判断文件是否存在
			System.out.println(file.getAbsolutePath() + "/t找不到指定的文件");
			return results;
		}
		
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		String[] temp;	
		Expenditure oneExp;	// 一条消费记录
		Income oneIncome;		// 一条收入记录
		String date = null;	// 用来存日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		while ((lineTxt = bufferedReader.readLine()) != null) {
			lineTxt = lineTxt.trim();
			temp = lineTxt.split(" ");
			if(lineTxt.length() == 8 && lineTxt.startsWith("201") && temp.length == 1) {	// lineTxt是日期
				date = lineTxt;
			} else if(temp.length >= 2) {	// 是有效数据
				oneExp = new Expenditure();
				oneExp.setOccurrencedTime(sdf.parse(date));
				for (int i = 0; i < temp.length; i++) {
					if(!temp[i].equals("")) {
						if(oneExp.getRemark() == null) {
							oneExp.setRemark(temp[i]);
						} else if (oneExp.getExpenditureAmount() == null) { 
							if(temp[i].startsWith("+")) {	// 收入
								oneIncome = new Income();
								incomes.add(oneIncome);
								oneIncome.setOccurrencedTime(oneExp.getOccurrencedTime());
								oneIncome.setRemark(oneExp.getRemark());
								oneIncome.setIncomeAmount(new BigDecimal(temp[i]));
							} else {	// 支出
								oneExp.setExpenditureAmount(new BigDecimal(temp[i]));
								exps.add(oneExp);
							}
						}
					}
				}
			}
		}
		read.close();
		return results;
	}
	
}
