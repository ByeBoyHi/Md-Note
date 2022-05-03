package code11_常用类.test05_其他类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01_Date {
	public static void main(String[] args) throws ParseException {
		test03();
	}

	/*
	 * 基本用法
	 */
	public static void test01() {
		// 创建一个Date对象
		Date today = new Date();
		System.out.println(today); // 表示当前时间
		System.out.println(today.getTime()); // 毫秒数

		// 创建一个Date，表示指定的日期
		// Date date = new Date(2019, 2, 14);
		Date date = new Date(0); // 传入的是毫秒值
		System.out.println(date); // 显示的是本地时区的时间

	}

	/*
	 * 常用方法
	 */
	public static void test02() {
		Date date = new Date();

		// getYear()、getMonth()、getDate()、getHours()等，都已过时

		// getTime() 获取毫秒值
		System.out.println(date.getTime());

		// setTime() 设置毫秒值
		date.setTime(6666);
		System.out.println(date);

		// after() 判断某个日期是否在指定日期之后
		Date d1 = new Date(222);
		Date d2 = new Date(111);
		System.out.println(d1.after(d2));

		// before() 判断某个日期是否在指定日期之前
		System.out.println(d1.before(d2));
		
		/*
		 * a.compareTo(b) 对两个日期进行比较
		 * 如果a>b，则返回1，如果a<b，则返回-1，如果a==b，则返回0
		 */
		Date d3 = new Date(111);
		System.out.println(d1.compareTo(d2));
		System.out.println(d2.compareTo(d1));
		System.out.println(d2.compareTo(d3));
		
	}

	/*
	 * Date和String的转换
	 */
	public static void test03() throws ParseException{
		Date date = new Date();
		
		/*
		 * 将日期转换为字符串
		 */
		// 1.创建SimpleDateFormat对象，指定目标格式，如 2019-2-14 12:30:25
		DateFormat df = new SimpleDateFormat("E yyyy年MM月dd日 HH:mm:ss"); 
		// 2.调用format()进行格式化
		String str = df.format(date);
		System.out.println(str);
		
		/*
		 * 将字符串转换为日期
		 */
		String s="2008年12月8日";
		
		// 1.创建SimpleDateFormat对象，指定字符串的日期格式
		DateFormat df2=new SimpleDateFormat("yyyy年MM月dd日");
		// 2.调用parse()解析为日期
		Date d = df2.parse(s);
		System.out.println(d);
		
		
		
		
		
	}
}
