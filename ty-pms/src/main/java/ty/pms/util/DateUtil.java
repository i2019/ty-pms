package ty.pms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 *         <a href="mailto:dan@getrolling.com">Dan Kibler </a> to correct time
 *         pattern. Minutes should be mm not MM (MM is month).
 */
public final class DateUtil {
	private static final String FORMAT_YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
	private static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	private static final String FORMAT_YYYY_MM="yyyy-MM";
	private static Log log = LogFactory.getLog(DateUtil.class);
	private static final String TIME_PATTERN = "HH:mm";

	/**
	 * Checkstyle rule: utility classes should not have public constructor
	 */
	private DateUtil() {
	}

	/**
	 * 取得指定日期所在周的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 取得指定日期所在周的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * Return default datePattern (yyyy-MM-dd)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		String defaultDatePattern = FORMAT_YYYY_MM_DD;
		return defaultDatePattern;
	}

	public static String getDateTimePattern() {
		return DateUtil.getDatePattern() + " HH:mm:ss.S";
	}

	/**
	 * Clear time, only keep yyyy-MM-dd 清除时分秒，只保存年月日
	 * 
	 * @return
	 */
	public static Date getCleanDate(Date date) {
		Date cleanDate = null;
		try {
			String strDate = DateUtil.getDate(date);
			cleanDate = DateUtil.convertStringToDate(strDate);
		} catch (ParseException e) {
			log.error(e);
		}
		return cleanDate;
	}

	/**
	 * This method attempts to convert date to format yyyy-MM-dd.
	 * 
	 * @param aDate
	 *            date from database as a string
	 * @return formatted string for the ui
	 */
	public static String getDate(Date aDate) {
		SimpleDateFormat df;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(getDatePattern());
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static String getMonthOfYear(Date aDate){
		SimpleDateFormat df;
		String returnValue = "";

		if (aDate != null) {
			df = new SimpleDateFormat(FORMAT_YYYY_MM);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}
	/**
	 * This method generates a string representation of a date/time in the
	 * format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param strDate
	 *            a string representation of a date
	 * @return a converted Date object
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 * @see java.text.SimpleDateFormat
	 */
	public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
		if (strDate == null) {
			return null;
		}
		SimpleDateFormat df;
		Date date;
		df = new SimpleDateFormat(aMask);

		// if (log.isDebugEnabled()) {
		// log.debug("converting '" + strDate + "' to date with mask '" + aMask
		// + "'");
		// }

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			// log.error("ParseException: " + pe);
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	/**
	 * This method returns the current date time in the format: MM/dd/yyyy HH:MM
	 * a
	 * 
	 * @param theTime
	 *            the current time
	 * @return the current date/time
	 */
	public static String getTimeNow(Date theTime) {
		return getDateTime(TIME_PATTERN, theTime);
	}

	/**
	 * This method returns the current date with clean time: yyyy-MM-dd
	 * 
	 * @return the current date
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Calendar getToday() {
		Date today = currentDateTime();
		SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
		// but it works ;-)
		String todayAsString = df.format(today);
		Calendar cal = new GregorianCalendar();
		try {
			cal.setTime(convertStringToDate(todayAsString));
		} catch (ParseException e) {
			throw new RuntimeException("unexpcepted exception, should not happen", e);
		}

		return cal;
	}

	public static Date currentDateTime() {
		return new Date();
	}

	/** 返回今天的日期，不带时分秒 */
	public static Date currentDate() {
		try {
			return convertStringToDate(convertDateToString(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 返回不带时分秒的日期 */
	public static Date cleanTimeDate(Date date) {
		try {
			return convertStringToDate(convertDateToString(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method generates a string representation of a date's date/time in
	 * the format you specify on input
	 * 
	 * @param aMask
	 *            the date pattern the string is in
	 * @param aDate
	 *            a date object
	 * @return a formatted string representation of the date
	 * @see java.text.SimpleDateFormat
	 */
	public static String getDateTime(String aMask, Date aDate) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			log.warn("aDate is null!");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static Date convertDateToDate(String aMask, Date date) {
		if (date == null) {
			log.warn("date is null!");
			return null;
		}
		String createTime = DateUtil.getDateTime(aMask, date);
		try {
			return convertStringToDate(aMask, createTime);
		} catch (ParseException e) {
			log.warn(e);
			return null;
		}

	}

	/**
	 * This method generates a string representation of a date based on the
	 * System Property 'dateFormat' in the format you specify on input
	 * 
	 * @param aDate
	 *            A date to convert
	 * @return a string representation of the date
	 */
	public static String convertDateToString(Date aDate) {
		return getDateTime(getDatePattern(), aDate);
	}

	/**
	 * This method converts a String to a date using the datePattern
	 * 
	 * @param strDate
	 *            the date to convert (in format MM/dd/yyyy)
	 * @return a date object
	 * @throws ParseException
	 *             when String doesn't match the expected format
	 */
	public static Date convertStringToDate(final String strDate) throws ParseException {
		return convertStringToDate(getDatePattern(), strDate);
	}

	/**
	 * 取一天的开始
	 * 
	 * @param aMask
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getDaysBegin(String aMask, String strDate) {
		Date date = null;
		try {
			date = convertStringToDate(aMask, strDate);
			date = daysBegin(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date;
	}

	public static Date daysBegin(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		date = cal.getTime();
		return date;
	}

	/**
	 * 取一天的结束
	 * 
	 * @param aMask
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getDaysEnd(String aMask, String strDate) {
		Date date = null;
		try {
			date = convertStringToDate(aMask, strDate);
			date = daysEnd(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date;

	}

	public static Date daysEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		date = cal.getTime();
		return date;
	}

	/** 获得每个月的第一天是星期几 */
	public static int getWeek(final int y, final int m) {
		Calendar cal = Calendar.getInstance();// 获得当前日期时间的方法
		cal.set(Calendar.YEAR, y); // 设置改为你输入的年
		cal.set(Calendar.MONTH, m - 1);
		cal.set(Calendar.DATE, 1);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;// 获得每个月第一天是星期几
		return (w);// 返回星期几
	}

	/** 获得每个月天数 */
	public static int getDay(final int y, final int m) {
		int day;
		if ((y % 100 == 0) || (y % 4 == 0 && y % 100 != 0)) {
			int[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			day = days[m - 1];
		} else {
			int[] days1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			day = days1[m - 1];
		}
		return day;
	}

	/**
	 * 获取一段时间内的天
	 * 
	 * @param ksrq
	 *            格式：2012-05-01
	 * @param jsrq
	 *            格式：2012-06-01
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<String> getDays(String ksrq, String jsrq) {
		List<String> list = new ArrayList<String>();
		try {
			Date d_ksrq = convertStringToDate(FORMAT_YYYY_MM_DD, ksrq);
			Date d_jsrq = convertStringToDate(FORMAT_YYYY_MM_DD, jsrq);
			list.add(getDateTime(FORMAT_YYYY_MM_DD, d_ksrq));
			while (d_jsrq.after(d_ksrq)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(d_ksrq);
				cal.add(cal.DATE, 1);
				d_ksrq = cal.getTime();
				list.add(getDateTime(FORMAT_YYYY_MM_DD, d_ksrq));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取一段时间内的天
	 * 
	 * @param ksrq
	 *            格式：2012-05-01
	 * @param jsrq
	 *            格式：2012-06-01
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static List<String> getDays(Date d_ksrq, Date d_jsrq) {
		List<String> list = new ArrayList<String>();
		try {
			list.add(getDateTime(FORMAT_YYYY_MM_DD, d_ksrq));
			while (d_jsrq.after(d_ksrq)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(d_ksrq);
				cal.add(cal.DATE, 1);
				d_ksrq = cal.getTime();
				list.add(getDateTime(FORMAT_YYYY_MM_DD, d_ksrq));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取一段时间内的天
	 * 
	 * @param ksrq
	 *            格式：2012-05-01
	 * @param jsrq
	 *            格式：2012-06-01
	 * @return List<Date>
	 */
	@SuppressWarnings("static-access")
	public static List<Date> getDayList(Date d_ksrq, Date d_jsrq) {
		List<Date> list = new ArrayList<Date>();
		try {
			list.add(d_ksrq);
			while (d_jsrq.after(d_ksrq)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(d_ksrq);
				cal.add(cal.DATE, 1);
				d_ksrq = cal.getTime();
				list.add(d_ksrq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/** 根据一段日期获取其中所有星期几的日期,星期以1~7表示 */
	public static List<String> getWeekDay(String dateFromStr, String dateToStr, int dayOfWeek) throws Exception {
		Date sd = DateUtil.convertStringToDate(FORMAT_YYYY_MM_DD, dateFromStr);
		Date ed = DateUtil.convertStringToDate(FORMAT_YYYY_MM_DD, dateToStr);
		if (dayOfWeek == 7) {
			dayOfWeek = 0;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(sd);
		int day = c.get(Calendar.DAY_OF_WEEK) - 1;
		List<String> tmp = new ArrayList<String>();
		if (day != dayOfWeek) {
			int dif = dayOfWeek < day ? (dayOfWeek - day + 7) : (dayOfWeek - day);
			c.add(Calendar.DATE, dif);
		}
		while (!c.getTime().after(ed)) {
			tmp.add(DateUtil.getDateTime(FORMAT_YYYY_MM_DD, c.getTime()));
			c.add(Calendar.DATE, 7);
		}
		return tmp;
	}

	public static List<String> getWeekDay(String dateFromStr, String dateToStr, int[] dayOfWeeks) throws ParseException {
		Date sd = DateUtil.convertStringToDate(FORMAT_YYYY_MM_DD, dateFromStr);
		Date ed = DateUtil.convertStringToDate(FORMAT_YYYY_MM_DD, dateToStr);
		Set<Integer> daySet = new HashSet<Integer>();
		for (int i = 0; i < dayOfWeeks.length; i++) {
			if (dayOfWeeks[i] == 7) {
				daySet.add(0);
			} else if (dayOfWeeks[i] < 0 || dayOfWeeks[i] > 6) {
				continue;
			} else {
				daySet.add(dayOfWeeks[i]);
			}
		}
		Calendar start = Calendar.getInstance();
		start.setTime(sd);

		List<String> tmp = new ArrayList<String>();
		while (!start.getTime().after(ed)) {
			if (daySet.contains(start.get(Calendar.DAY_OF_WEEK) - 1)) {
				tmp.add(DateUtil.getDateTime(FORMAT_YYYY_MM_DD, start.getTime()));
			}
			start.add(Calendar.DATE, 1);
		}
		return tmp;
	}

	public static List<String> getWeekDay(Date sd, Date ed, int[] dayOfWeeks) throws ParseException {
		Set<Integer> daySet = new HashSet<Integer>();
		for (int i = 0; i < dayOfWeeks.length; i++) {
			if (dayOfWeeks[i] == 7) {
				daySet.add(0);
			} else if (dayOfWeeks[i] < 0 || dayOfWeeks[i] > 6) {
				continue;
			} else {
				daySet.add(dayOfWeeks[i]);
			}
		}
		Calendar start = Calendar.getInstance();
		start.setTime(sd);

		List<String> tmp = new ArrayList<String>();
		while (!start.getTime().after(ed)) {
			if (daySet.contains(start.get(Calendar.DAY_OF_WEEK) - 1)) {
				tmp.add(DateUtil.getDateTime(FORMAT_YYYY_MM_DD, start.getTime()));
			}
			start.add(Calendar.DATE, 1);
		}
		return tmp;
	}

	public static List<String> getMonthWeekDay(String month, int[] dayOfWeeks) throws ParseException {
		Date startDate = DateUtil.convertStringToDate(month);
		Calendar first = Calendar.getInstance();
		first.setTime(startDate);
		first.set(Calendar.DAY_OF_MONTH, 1);

		int maxDays = first.getActualMaximum(Calendar.DAY_OF_MONTH);
		Calendar end = Calendar.getInstance();
		end.setTime(startDate);
		end.set(Calendar.DAY_OF_MONTH, maxDays);
		return getWeekDay(DateUtil.getDate(first.getTime()), DateUtil.getDate(end.getTime()), dayOfWeeks);
	}

	public static List<String> getMonthWeekDay(String[] months, int[] dayOfWeeks) throws ParseException {
		List<String> result = new ArrayList<String>();
		for (String month : months) {
			if (StringUtils.isNotBlank(month)) {
				result.addAll(getMonthWeekDay(month, dayOfWeeks));
			}
		}
		return result;
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startTime
	 * @param endTime
	 * @param format
	 * @return
	 */
	public static Integer dateDiff(Date startTime, Date endTime) {
		try {
			Float nd = new Float(1000 * 24 * 60 * 60);// 一天的毫秒数
			Float diff = new Float(endTime.getTime() - startTime.getTime());
			Float day = diff / nd;// 计算差多少天

			return day.intValue();
		} catch (Exception e) {
			return 0;
		}
	}

	// public static void main(String[] args) {
	// try {
	//
	// int day =
	// DateUtil.dateDiff(DateUtil.convertStringToDate(DateUtil.convertDateTimeToString(new
	// Date())), DateUtil.convertStringToDate("2014-04-05"));
	// System.out.println(day);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	/**
	 * 两个日期之间相差多少天  默认格式yyyy-MM-dd
	 */
	public static Long dateDiff(String startTime, String endTime) {
		return dateDiff(startTime, endTime, getDatePattern());
	}
	/**
	 * 两个日期之间相差多少天
	 * 
	 * @param startTime
	 * @param endTime
	 * @param format
	 * @return
	 */
	public static Long dateDiff(String startTime, String endTime, String format) {

		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		// long nh = 1000 * 60 * 60;// 一小时的毫秒数
		// long nm = 1000 * 60;// 一分钟的毫秒数
		// long ns = 1000;// 一秒钟的毫秒数
		long diff;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			long day = diff / nd;// 计算差多少天
			// long hour = diff % nd / nh;// 计算差多少小时
			// long min = diff % nd % nh / nm;// 计算差多少分钟
			// long sec = diff % nd % nh % nm / ns;// 计算差多少秒
			return day;
		} catch (ParseException e) {
			log.error(e);
		}
		return null;
	}

	public static void main(String[] args) {
		Date twoDayAgo = DateUtil.addDays(new Date(), -2);
		System.out.println(convertDateToString(twoDayAgo));
		System.out.println(dateDiff("2014-04-28", "2014-04-28", getDatePattern()));
	}

	public static Date[] getCalendar(Date date) {
		Calendar first = Calendar.getInstance();
		first.setTime(date);
		first.set(Calendar.DAY_OF_MONTH, 1);
		first.add(Calendar.DATE, -(first.get(Calendar.DAY_OF_WEEK) - 1));

		Calendar last = Calendar.getInstance();
		last.setTime(date);
		last.set(Calendar.DAY_OF_MONTH, getDay(last.get(Calendar.YEAR), last.get(Calendar.MONTH) + 1));
		last.add(Calendar.DATE, (7 - last.get(Calendar.DAY_OF_WEEK)));
		Date[] dates = new Date[] { first.getTime(), last.getTime() };
		return dates;
	}

	public static Date[] get42DayCalendar(Date date) {
		Calendar first = Calendar.getInstance();
		first.setTime(date);
		first.set(Calendar.DAY_OF_MONTH, 1);
		first.add(Calendar.DATE, -(first.get(Calendar.DAY_OF_WEEK) - 1));

		Calendar last = Calendar.getInstance();
		last.setTime(first.getTime());
		last.add(Calendar.DATE, 41);
		Date[] dates = new Date[] { first.getTime(), last.getTime() };
		return dates;
	}

	public static int getDayOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_YEAR);
	}

	public static Date nextDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, +1);
		return c.getTime();
	}

	public static Date previousMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}

	public static Date nextMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, +1);
		return c.getTime();
	}

	public static Date lastMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}

	public static Date cloneDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTime();
	}

	public static String convertDateTimeToString(Date date) {
		String pattern = FORMAT_YYYY_MM_DD + " HH:mm:ss";
		return getDateTime(pattern, date);
	}

	public static String convertDateHourToString(Date date) {
		String pattern = FORMAT_YYYY_MM_DD + " HH:00:00";
		return getDateTime(pattern, date);
	}
	
	/**
	 * 生成从开始日期到结束日期内的日期列表,如果星期标识不为空的时候，只包含flag为true的日期
	 * 
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<Date> createDateList(String startDateStr, String endDateStr, Map weekFlag) {
		List<Date> dateList = new ArrayList<Date>();
		try {
			Date startDate = convertStringToDate(FORMAT_YYYY_MM_DD_T_HH_MM_SS, startDateStr);
			Date endDate = convertStringToDate(FORMAT_YYYY_MM_DD_T_HH_MM_SS, endDateStr);

			int days = dateDiff(startDate, endDate);

			final String weekNames[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

			for (int i = 0; i <= days; i++) {

				Calendar c = Calendar.getInstance();
				c.setTime(startDate);
				c.add(Calendar.DATE, i);
				Date varDate = c.getTime();

				if (weekFlag != null) {
					String weekName = weekNames[c.get(Calendar.DAY_OF_WEEK) - 1];

					boolean include = (Boolean) weekFlag.get(weekName);
					if (include) {
						dateList.add(varDate);
					}

				} else {
					dateList.add(varDate);
				}

			}

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return dateList;
	}

	/**
	 * 获取当前年月+11个月
	 * 
	 * */
	public static List<Date> getOneYearDate() {
		List<Date> list = new ArrayList<Date>();
		Calendar c = Calendar.getInstance();
		list.add(c.getTime());
		for (int i = 0; i < 11; i++) {
			c.add(Calendar.MONTH, +1);
			list.add(c.getTime());
		}
		return list;
	}

	/**
	 * 取一年后的日期
	 * 
	 * @return
	 */
	public static Date getAfterYearTime() {
		Date date = currentDateTime();
		long afterTime = (date.getTime() / 1000) + 60 * 60 * 24 * 365;
		date.setTime(afterTime * 1000);
		return date;
	}

	public static List<Date[]> splitTimeByDays(Date start, Date end, int days) {
		return splitTimeByHours(start, end, 24 * days);
	}

	public static List<Date[]> splitTimeByHours(Date start, Date end, int hours) {
		List<Date[]> dl = new ArrayList<Date[]>();
		while (start.compareTo(end) < 0) {
			Date _end = addHours(start, hours);
			if (_end.compareTo(end) > 0) {
				_end = end;
			}
			Date[] dates = new Date[] { (Date) start.clone(), (Date) _end.clone() };
			dl.add(dates);

			start = _end;
		}
		return dl;
	}

	public static Date addMinutes(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE, amount);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @param hhmm
	 * @return
	 */
	public static Date setDateHHmmss(Date date, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		return c.getTime();
	}

	public static Date addHours(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, amount);
		return c.getTime();
	}

	public static Date addDays(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, amount);
		return c.getTime();
	}

	public static Date addMonths(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, amount);
		return c.getTime();
	}

	/**
	 * 获取当前系统时间所在月的最后一天
	 * 
	 * @return
	 */
	public static String getCurrentMonthLastDay(Date start) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(start);
		int endday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, endday);
		return convertDateToString(calendar.getTime());
	}

	/**
	 * 根据年和月获取所在月的最后一天的日期
	 * 
	 * @return
	 */
	public static String getMonthLastDay(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int endday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, endday);
		return convertDateToString(calendar.getTime());
	}

	/**
	 * 根据年和月获取所在月的最后一天的日期
	 * 
	 * @return
	 */
	public static Date getMonthLastDayByYM(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int endday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, endday);
		return calendar.getTime();
	}

	/**
	 * 判断日期是否是周末
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isWeekend(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		if (week == 6 || week == 7) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 一天的开始
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

		return calendar.getTime();
	}

	/**
	 * 判断日期是星期几 2:星期一；3：星期二...7:星期六;1:星期天
	 */
	public static int getWeekday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		return weekday;
	}

	/**
	 * 判断日期是否在某一时间段内，包含起始天
	 * 
	 * @param start
	 * @param end
	 * @param target
	 * @return 存在返回true
	 */
	public static boolean judge(Date start, Date end, Date target) {
		if (target.before(start)) {
			return false;
		}
		if (target.after(end)) {
			return false;
		}
		return true;
	}

	public static Date addSecond(Date date, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.SECOND, amount);
		return c.getTime();
	}
	
	/**
	 * 获取指定日期的前几天或者后今天
	 * day  -1 前一天
	 * day  1 后一天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getDay(Date date,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return date;
	}

	
	
}
