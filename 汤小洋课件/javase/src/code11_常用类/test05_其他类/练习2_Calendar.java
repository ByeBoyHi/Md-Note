package code11_常用类.test05_其他类;

import java.util.Calendar;

/*
 * 获取2008年2月有多少天
 * 
 * 相当于求本月的最后一天，而本后的最后一天就是下个月的第一天的前一天，如7.31就是8.1的前一天
 */
public class 练习2_Calendar {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, 2008);
		c.set(Calendar.MONDAY, Calendar.FEBRUARY+1);
		c.set(Calendar.DATE, 1);
		
		c.add(Calendar.DATE, -1);
		System.out.println(c.getTime());
		
		System.out.println(c.get(Calendar.DATE));
	}
}
