package code11_常用类.test05_其他类;

import java.text.ParseException;
import java.util.Date;

/*
 * 定义一个日期工具类DateUtil，实现以下的功能
 * 1.将Date转换为String
 * 2.将String转换为Date
 * 3.计算日期的下一天
 * 4.计算两个日期间相关的天数
 * 5.获取日期中的年、月、日、时、分、秒
 */
public class 练习1_Date {
	public static void main(String[] args) throws ParseException {
		
		Date date = new Date();
		System.out.println(DateUtil.toString(date, "yyyy年MM月dd日 E"));
		System.out.println(DateUtil.toString(date));
		
		String string="2/14/2019 12:30:25";
		Date date2 = DateUtil.toDate(string, "MM/dd/yyyy HH:mm:ss");
		System.out.println(date2);
		
		System.out.println(DateUtil.getNextDay(date));
		
		System.out.println(DateUtil.getDuringDays(date2, date));
		
		System.out.println(DateUtil.get(date, DateUtil.MONTH));
		System.out.println(DateUtil.get(date, DateUtil.MINUTE));
	}
}
