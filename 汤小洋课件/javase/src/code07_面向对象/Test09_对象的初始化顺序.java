package code07_面向对象;

public class Test09_对象的初始化顺序 {
	public static void main(String[] args) throws ClassNotFoundException {
		User user = new User();
		System.out.println(user.name);
		// User user2 = new User();

		// User.b();

		// 加载指定的类
		// Class.forName("code07_面向对象.User");
		// System.out.println(User.hobby);

	}
}

class User {
	String name = "张三"; // 实例属性
	static String hobby = "吃饭"; // 静态属性

	public void a() {
		System.out.println("实例方法。。。。。。");
	}

	public static void b() {
		System.out.println("静态方法。。。。。。。");
	}

	public User() {
		System.out.println("构造方法。。。。。。");
	}

	{
		name="李四";
		System.out.println("代码块。。。。。。");
	}

	static {
		hobby = "睡觉";
		System.out.println("静态代码块。。。。。。");
	}
}
