package code18_设计模式.test03_工厂模式.demo02;

import java.util.Date;

public class UserServiceImpl implements UserService {

	// 依赖于Date对象
	Date date = (Date) ObjectFactory.getObject("date");

	@Override
	public void login() {
		System.out.println("UserServiceImpl.login()");

		System.out.println(date.getTime());
	}

}
