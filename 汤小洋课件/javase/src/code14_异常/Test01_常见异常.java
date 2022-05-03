package code14_异常;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test01_常见异常 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 算术异常
		 int a=5;
		 int b=0;
		 System.out.println(a/b);

		// 数组下标越界异常
		 int[] nums={12,4,6};
		 System.out.println(nums[-1]);

		// 空指针异常
		// String name=null;
		// System.out.println(name.equals("tom"));
		// System.out.println("tom".equals(name)); // 两者的区别

		// 类型转换异常
		// Object obj = new Object();
		// String str=(String) obj;

		// 数字格式异常
		// int a = Integer.parseInt("abc");

		// 类找不到异常
		// Class.forName("java.lang.Str"); //加载指定的类

		// 解析异常
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		df.parse("2019/2/14");

		System.out.println("异常后面的代码。。。。。");
	}
}
