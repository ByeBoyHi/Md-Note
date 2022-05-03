package code14_异常;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test04_声明抛出异常 {
	public static void main(String[] args) throws ParseException{
		
		// 方法的调用者来处理，如果调用者不处理，则会继续向上抛出，最终由JVM处理，JVM的处理方式就是控制台打印异常信息
		try {
			parseDate("2019/12/4");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(divide(5, 2));
		
	}
	
	/*
	 * 解析日期，将字符串转换为日期
	 * throws后面可以跟多个异常类型，以逗号隔开
	 * 可以使用一个大异常来表示多个子异常，但不建议，可读性比较差
	 */
	public static Date parseDate(String str) throws ParseException, ClassNotFoundException{
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		// 方式1：使用try...catch在方法内处理异常
//		try {
//			Date date = df.parse(str);
//			return date;
//		} catch (ParseException e) {
//			System.out.println("解析失败："+str+"不是有效的日期格式！");
//		}
//		return null;
		
		// 方式2：使用throws声明方法会抛出异常
		Date date = df.parse(str);
		
		Class.forName("java.lang.String");
		
		return date;
	}
	
	/*
	 * 除法运算
	 */
	public static int divide(int num1,int num2) throws ArithmeticException{
		if(num2==0){
			// ArithmeticException e=new ArithmeticException("除数不能为零");
			// throw e;
			throw new ArithmeticException("除数不能为零"); // 使用throw手动抛出异常
		}
		return num1/num2;
	}
	
	
	
	
}
