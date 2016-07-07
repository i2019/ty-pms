package ty.pms.action.base;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import ty.pms.util.DateUtil;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * This class implements a Struts Type Converter and can be used by struts to
 * convert Date's to Strings
 * 
 * @author mraible
 */
public class DateConverter extends StrutsTypeConverter {
	 
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map ctx, String[] value, Class arg2) {
		if (value[0] == null || value[0].trim().equals("")) {
			return null;
		}

		try {
			String yyyyMMDDReg = "[0-9]{4}[-/][0-9]{1,2}[-/][0-9]{1,2}";
			if (value[0].matches(yyyyMMDDReg)) {
				return DateUtil.convertStringToDate("yyyy-MM-dd", value[0]);
			}
			
			yyyyMMDDReg = "[0-9]{4}[0-9]{1,2}[0-9]{1,2}";
			if (value[0].matches(yyyyMMDDReg)) {
				return DateUtil.convertStringToDate("yyyyMMdd", value[0]);
			}

			String yyyyMMDDHHReg = "[0-9]{4}[-/][0-9]{1,2}[-/][0-9]{1,2} [0-9]{1,2}";
			if (value[0].matches(yyyyMMDDHHReg)) {
				return DateUtil.convertStringToDate("yyyy-MM-dd HH", value[0]);
			}

			String yyyyMMDDHHmmReg = "[0-9]{4}[-/][0-9]{1,2}[-/][0-9]{1,2} [0-9]{1,2}[:/][0-9]{1,2}";
			if (value[0].matches(yyyyMMDDHHmmReg)) {
				return DateUtil.convertStringToDate("yyyy-MM-dd HH:mm", value[0]);
			}

			String yyyyMMDDHHmmssReg = "[0-9]{4}[-/][0-9]{1,2}[-/][0-9]{1,2} [0-9]{1,2}[:/][0-9]{1,2}[:/][0-9]{1,2}";
			if (value[0].matches(yyyyMMDDHHmmssReg)) {
				return DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", value[0]);
			}

			String hhmmReg = "[0-9]{1,2}[:/][0-9]{1,2}";
			if (value[0].matches(hhmmReg)) {
				return DateUtil.convertStringToDate("HH:mm", value[0]);
			}

			String hhmmssReg = "[0-9]{1,2}[:/][0-9]{1,2}[:/][0-9]{1,2}";
			if (value[0].matches(hhmmssReg)) {
				return DateUtil.convertStringToDate("HH:mm:ss", value[0]);
			}

			return DateUtil.convertStringToDate(value[0]);
		} catch (ParseException pe) {
			throw new TypeConversionException(pe.getMessage(), pe);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public String convertToString(Map ctx, Object data) {
		Date d = (Date) data;
		if (d.getHours() > 0 && d.getMinutes() >= 0) {
			return DateUtil.getDateTime("yyyy-MM-dd HH:mm", d);
		}
		return DateUtil.convertDateToString(d);
	}
}