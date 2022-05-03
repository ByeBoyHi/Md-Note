package code18_设计模式.test04_代理模式.demo01;

public class UserServiceImpl implements UserService {

	@Override
	public void login(String username, String password) {
		System.out.println("UserServiceImpl.login():"+username+","+password);
	}

	@Override
	public String logout() {
		System.out.println("UserServiceImpl.logout()");
		return "byebye";
	}

}
