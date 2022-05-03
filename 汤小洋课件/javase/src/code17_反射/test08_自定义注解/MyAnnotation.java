package code17_反射.test08_自定义注解;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;

/*
 * 作用域的取值：
 * 	TYPE 类、接口
 * 	FIELD 属性
 * 	METHOD 方法
 * 	PARAMETER 方法参数
 * 	CONSTRUCTOR 构造方法
 * 	注：可以同时指定多个值，需要将多个值放到大括号中{}，以逗号隔开
 */
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
/*
 * 生命周期的取值：
 * 	SOURCE 注解只保留在源文件中，不参与编译，即class文件中没有
 * 	CLASS  注解参与编译，保留在class文件中，但类加载时不加载，即程序运行时没有
 * 	RUNTIME	注解可以保存在程序运行期间，可以通过反射获取该注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {
	
	/*
	 * 抽象方法，必须是无参无异常
	 */
//	String a();
	
//	int b();
	
	/*
	 * 返回数组类型时，使用大括号{}
	 */
//	String[] c();
	
	/*
	 * 使用default关键字为方法指定默认的返回值，在使用注解时可以不指定该属性
	 */
	String d() default "ddd";
	
	/*
	 * 推荐使用value()名称，在赋值时如果只为该属性赋值，则可以省略value=
	 */
	String value() default "defaultValue";
	
}
