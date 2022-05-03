package code17_反射;

import code16_线程.test09_线程单例.User;

public class Test01_类加载器 {
	public static void main(String[] args) {
		// 获取当前类的类加载器
		ClassLoader loader = Test01_类加载器.class.getClassLoader();
		System.out.println(loader);

		System.out.println(User.class.getClassLoader());

		System.out.println(String.class.getClassLoader());
		
	}
}
