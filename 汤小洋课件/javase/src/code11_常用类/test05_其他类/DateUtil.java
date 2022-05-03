package code11_常用类.test05_其他类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final int YEAR = 0;
	public static final int MONTH = 1;
	public static final int DATE = 2;
	public static final int HOUR = 3;
	public static final int MINUTE = 4;
	public static final int SECOND = 5;

	/**
	 * 
	 * <将Date转换为String>
	 * 
	 * @param date
	 * @param pattern
	 *            指定格式化字符串
	 * @return
	 * @date 2019年2月18日 上午9:10:57
	 */
	public static String toString(Date date, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 
	 * <将Date转换为String，默认格式为yyyy-MM-dd HH:mm:ss>
	 * 
	 * @param date
	 * @return
	 * @date 2019年2月18日 上午9:11:18
	 */
	public static String toString(Date date) {
		return toString(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * <将String转换为Date>
	 * 
	 * @param string
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @date 2019年2月18日 上午9:14:04
	 */
	public static Date toDate(String string, String pattern)
			throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.parse(string);
	}

	/**
	 * 
	 * <将String转换为Date，默认格式为yyyy-MM-dd HH:mm:ss>
	 * 
	 * @param string
	 * @return
	 * @throws ParseException
	 * @date 2019年2月18日 上午9:14:53
	 */
	public static Date toDate(String string) throws ParseException {
		return toDate(string, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 
	 * <计算日期的下一天>
	 * 
	 * @param date
	 * @return 下一天的Date
	 * @date 2019年2月18日 上午9:19:47
	 */
	public static Date getNextDay(Date date) {
		long time = date.getTime() + 24 * 60 * 60 * 1000;
		return new Date(time);
	}

	/**
	 * 
	 * <计算两个日期间相关的天数>
	 * 
	 * @param startDate
	 * @param endDate
	 * @return 相隔的天数
	 * @date 2019年2月18日 上午9:22:46
	 */
	public static int getDuringDays(Date startDate, Date endDate) {
		int days = 0;
		while (startDate.before(endDate)) {
			startDate = getNextDay(startDate);
			days++;
		}
		return days;
	}

	/**
	 * 
	 * <获取日期中的年、月、日、时、分、秒>
	 * 
	 * @param date
	 * @param field
	 *            日期中的字段
	 * @return
	 * @date 2019年2月18日 上午9:30:30
	 */
	public static int get(Date date, int field) {
		String s = toString(date);
		String[] arr = s.split("-|\\s|:");
		return Integer.parseInt(arr[field]);

	}

}
