package code14_异常;

import java.text.ParseException;

public class Test06_方法重写的异常问题 {

}

class A {
	public void show() throws Exception{
		System.out.println("A.show()");
	}
}

class B extends A {

	@Override
	public void show() throws ParseException, ClassNotFoundException{
		System.out.println("B.show()");
		
		Class.forName("java.lang.String");
		
	}

}