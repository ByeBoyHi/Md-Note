package code14_异常;

import java.util.Scanner;

public class Test05_自定义异常 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入用户名：");
		String username = input.next();
		System.out.print("请输入密码：");
		String password = input.next();

		// 调用注册方法，实现注册功能
		try {
			register(username, password);
			System.out.println("注册成功！");
		} catch (UsernameExistException e) {
			System.out.println("注册失败："+e.getMessage());
		}
	}

	/*
	 * 用户注册
	 */
	public static void register(String username, String password) throws UsernameExistException {
		if ("admin".equals(username) || "tom".equals(username)) {
			throw new UsernameExistException("用户名已存在");
		}

		// 将用户名和密码保存到数据库中

	}
}

/*
 * 自定义异常类
 */
class UsernameExistException extends Exception {

	public UsernameExistException() {
		super();
	}

	public UsernameExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameExistException(String message) {
		super(message);
	}

	public UsernameExistException(Throwable cause) {
		super(cause);
	}

}
