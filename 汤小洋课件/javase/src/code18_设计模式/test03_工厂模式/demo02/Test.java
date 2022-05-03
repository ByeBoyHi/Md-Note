package code18_设计模式.test03_工厂模式.demo02;

import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		// Date date = (Date) ObjectFactory.getObject("date");
		// System.out.println(date);
		//
		// Random random = (Random) ObjectFactory.getObject("random");
		// System.out.println(random);
		//
		// Date date2 = (Date) ObjectFactory.getObject("date");
		// System.out.println(date==date2);
		
		UserService userSerivce=(UserService) ObjectFactory.getObject("userService");
		userSerivce.login();
	}
}
