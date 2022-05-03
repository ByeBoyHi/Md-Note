package code17_反射;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test04_Field {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class cls = Student.class;
		
		//1.获取当前类及父类中所有public修饰的属性
		Field[] fields = cls.getFields();
		
		//2.获取当前类中所有的属性，包含private修饰的
		fields = cls.getDeclaredFields();
		
		for (Field f : fields) {
			// 属性名、属性类型、修饰符
			System.out.println(f.getName()+"\t"+f.getType()+"\t"+Modifier.toString(f.getModifiers()));
		}
		
		//3.获取当前类及父类中指定的public修饰的属性
		Field field = cls.getField("sex");
		
		//4.获取当前类中指定的属性
		field = cls.getDeclaredField("height");
		System.out.println(field);
		
		// 通过反射为属性赋值
		Student stu = new Student();
		field.setAccessible(true); // 取消权限控制检查，访问属性时忽略访问控制符（破坏了封装原则）
		field.set(stu, 180.5); //为stu对象的field属性赋值为180.5
		
		// 通过反射获取属性值
		Object value = field.get(stu); //获取stu对象的指定field属性
		System.out.println(value);
		
//		System.out.println(stu);
		
	}
}
