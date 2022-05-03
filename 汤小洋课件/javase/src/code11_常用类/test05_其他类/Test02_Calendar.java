package code11_常用类.test05_其他类;

import java.util.Calendar;
import java.util.Date;

public class Test02_Calendar {
	public static void main(String[] args) {
		// 创建一个Calendar实例
		Calendar c = Calendar.getInstance();
		System.out.println(c.getClass());

		/*
		 * 常用方法
		 */
		// getTime() 将Calendar转换为Date
		Date d = c.getTime();
		System.out.println(d);
		System.out.println(DateUtil.toString(d));

		// setTime() 设置时间为指定的Date
		// c.setTime(new Date(1112223334445L));
		// System.out.println(c.getTime());

		// get() 获取日期的指定字段
		System.out.println(c.get(Calendar.YEAR)); // 年
		System.out.println(c.get(Calendar.MONTH) + 1); // 月，返回值为0-11，0表示1月
		System.out.println(c.get(Calendar.DATE)); // 日
		System.out.println(c.get(Calendar.DAY_OF_MONTH)); // 一个月的第几天，等同于DATE
		System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 一周的第几天，返回值为1-7，1表示第1天（星期天）
		System.out.println(c.get(Calendar.DAY_OF_YEAR)); // 一年的第几天
		System.out.println(c.get(Calendar.HOUR)); // 时，12小时制
		System.out.println(c.get(Calendar.HOUR_OF_DAY)); // 24小时制
		System.out.println(c.get(Calendar.MINUTE)); // 分
		System.out.println(c.get(Calendar.SECOND)); // 秒
		System.out.println(c.get(Calendar.MILLISECOND)); // 毫秒

		// set() 设置日期时间
		c.set(2019, 1, 14); // 月份从0开始，1表示二月
		c.set(2019, Calendar.FEBRUARY, 14, 12, 30, 25); // 使用常量
		c.set(Calendar.YEAR, 2008); // 指定的field
		c.set(Calendar.DATE, 8);
		System.out.println(c.getTime());

		// add() 添加日期时间
		c.add(Calendar.YEAR, 2); // +2年
		c.add(c.DATE, 3); // +3天
		c.add(c.HOUR, 1); // +1小时
		System.out.println(c.getTime());

		// clear() 清空
		// c.clear();
		// System.out.println(c.getTime());

		// getTimeInMillis() 毫秒值
		System.out.println(c.getTimeInMillis());

		System.out.println(System.currentTimeMillis()); // 当前时间的毫秒值
	}
}
