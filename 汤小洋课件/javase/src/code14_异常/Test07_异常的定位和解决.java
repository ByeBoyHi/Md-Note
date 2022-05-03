package code14_异常;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test07_异常的定位和解决 {
	public static void main(String[] args) throws DateConvertException  {
		ClassA a = new ClassA();
		a.a();
	}
}

class ClassA {
	public void a() throws DateConvertException {
		System.out.println("ClassA.a()");

		ClassB b = new ClassB();
		b.b();
	}
}

class ClassB {
	public void b() throws DateConvertException {
		System.out.println("ClassB.b()");

		ClassC c = new ClassC();
		try {
			c.c();
		} catch (ParseException e) {
			// 进行异常转换，转换为自定义的异常
			throw new DateConvertException("日期转换出现异常：" + e.getMessage(), e); // 传入异常对象，表示异常发生的原由
		}
	}
}

class ClassC {
	public void c() throws ParseException {
		System.out.println("ClassC.c()");

		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019/2/14");
		System.out.println(date);
	}
}

class DateConvertException extends Exception {

	public DateConvertException() {
		super();
	}

	public DateConvertException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DateConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	public DateConvertException(String message) {
		super(message);
	}

	public DateConvertException(Throwable cause) {
		super(cause);
	}

}
