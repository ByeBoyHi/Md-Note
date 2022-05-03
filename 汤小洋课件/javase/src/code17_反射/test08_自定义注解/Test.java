package code17_反射.test08_自定义注解;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * 解析注解
 */
public class Test {
	public static void main(String[] args) throws Exception {
		
		// 获取类上的注解
		Class cls = Student.class;
		Annotation[] annotations = cls.getAnnotations(); // 获取所有注解
		Annotation annotation = cls.getAnnotation(MyAnnotation.class);
		
		// 获取属性上的注解
		Field field = cls.getDeclaredField("name");
		annotations = field.getAnnotations();
		annotation = field.getAnnotation(MyAnnotation.class);
		
		// 获取方法上的注解
		Method method = cls.getDeclaredMethod("show", int.class);
		annotations = method.getAnnotations();
		annotation = method.getAnnotation(MyAnnotation.class);
		
		for (Annotation a : annotations) {
			System.out.println(a);
		}
		System.out.println(annotation);
		
		// 通过反射获取注解的属性值
		if(annotation instanceof MyAnnotation){
			MyAnnotation ma=(MyAnnotation) annotation;
			System.out.println(ma.d());
			System.out.println(ma.value());
		}
		
		// 判断是否使用了指定的注解
		System.out.println(method.isAnnotationPresent(SuppressWarnings.class));
	}
}
