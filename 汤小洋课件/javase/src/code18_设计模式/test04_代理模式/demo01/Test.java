package code18_设计模式.test04_代理模式.demo01;

import code18_设计模式.test03_工厂模式.demo02.ObjectFactory;

public class Test {
	public static void main(String[] args) {
		UserService userService=(UserService) ObjectFactory.getObject("userServiceProxy");
		
		userService.login("admin", "123");
		
		System.out.println("---------------------------------");
		
		System.out.println(userService.logout());
	}
}
