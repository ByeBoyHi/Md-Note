package code17_反射;

import java.lang.reflect.Modifier;

public class Test03_常用方法 {
	public static void main(String[] args) {
		Class cls = Student.class;

		/*
		 * 获取类中的信息
		 */
		System.out.println("类全名：" + cls.getName()); // 包名.类名
		System.out.println("简单类名："+cls.getSimpleName());
		System.out.println("是否为接口："+cls.isInterface());
		
		// 获取父类
		Class superClass = cls.getSuperclass();
		System.out.println("父类："+superClass.getSimpleName());
		
		// 获取实现的接口
		Class[] interfaces = cls.getInterfaces();
		System.out.print("实现的接口：");
		for (Class c : interfaces) {
			System.out.print(c.getSimpleName()+"\t");
		}
		System.out.println();
		
		// 获取修饰符
		int modifiers = cls.getModifiers();
		System.out.println("修饰符："+Modifier.toString(modifiers));
		
		// 获取包
		Package pkg = cls.getPackage();
		System.out.println(pkg);
		
		// 调用无参构造方法创建对象
		try {
			Object obj=cls.newInstance();
			System.out.println(obj);
		} catch (InstantiationException e) {
			System.out.println("实例化异常："+e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("非法访问异常："+e.getMessage());
		}
		
	}
}
