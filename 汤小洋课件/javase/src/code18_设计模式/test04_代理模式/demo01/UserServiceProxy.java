package code18_设计模式.test04_代理模式.demo01;

import java.util.Date;

import code18_设计模式.test03_工厂模式.demo02.ObjectFactory;

public class UserServiceProxy implements UserService {

	// private UserService userService=new UserServiceImpl();

	/*
	 * 代理对象可以只声明目标对象的接口，不负责目标对象的创建，目标对象由外部创建并传入
	 */
	private UserService userService = (UserService) ObjectFactory
			.getObject("userService");

	@Override
	public void login(String username, String password) {
		System.out.println("login start:" + new Date().getTime());
		userService.login(username, password);
	}

	@Override
	public String logout() {
		System.out.println("logout start:" + new Date().getTime());
		return userService.logout();
	}

}
