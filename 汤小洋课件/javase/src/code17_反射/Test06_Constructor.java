package code17_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test06_Constructor {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class cls=Student.class;
		
		// 1.获取所有public修饰的构造方法
		Constructor[] constructors = cls.getConstructors();
		
		// 2.获取所有的构造方法
		constructors = cls.getDeclaredConstructors();
		
		for (Constructor c : constructors) {
			System.out.println(c);
		}
		
		// 3.获取指定的public修饰的构造方法
		Constructor c = cls.getConstructor(String.class,String.class,double.class);
		
		// 4.获取指定的构造方法
		c = cls.getDeclaredConstructor(String.class);
		System.out.println(c);
		
		// 通过反射调用构造方法，创建对象
		c.setAccessible(true);
		Object obj = c.newInstance("male");
		System.out.println(obj);
		
		// 直接调用Class对象的newInstance()方法创建对象
		Object obj2 = cls.newInstance();
		System.out.println(obj2);
		
	}
}
