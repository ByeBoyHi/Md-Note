package code17_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test05_Method {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class cls = Student.class;

		// 1.获取当前类及父类中所有的public修饰的方法
		Method[] methods = cls.getMethods();

		// 2.获取当前类中所有的方法，包含private修饰的
		methods = cls.getDeclaredMethods();
		
		for (Method m : methods) {
			// 方法名、返回值类型、修饰符、参数列表
			System.out.println(m.getName() + "\t" + m.getReturnType() + "\t"
					+ Modifier.toString(m.getModifiers()) + "\t"
					+ Arrays.toString(m.getParameters()));
		}
		
		// 3.获取当前类及父类中指定的public修饰的方法
		Method method = cls.getMethod("c", int.class,int.class);
		
		// 4.获取当前类中指定的方法
		method = cls.getDeclaredMethod("c", int.class,double.class);
		System.out.println(method);
		
		// 通过反射调用方法
		Student stu = new Student();
		method.setAccessible(true);
		Object value = method.invoke(stu, 4,3.5); // 调用stu对象的method方法，传入参数4和3.5
		System.out.println(value);
		
		
	}
}
