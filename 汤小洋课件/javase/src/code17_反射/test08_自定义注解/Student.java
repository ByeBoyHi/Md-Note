package code17_反射.test08_自定义注解;

@MyAnnotation
@Deprecated
public class Student {

	// @MyAnnotation(a = "aaa", b = 6, c = { "c1", "c2", "c3" })
	// 当数组中只有一个元素时，可以省略大括号
	// @MyAnnotation(a = "aaa", b = 6, c = "c1")
	// 当没有属性要赋值时，可以省略小括号
	// @MyAnnotation
	// 当只为value属性赋值时，可以省略value=，即如果省略属性名，表示为value属性赋值
	// @MyAnnotation("defaultValue")
	// 如果同时为多个属性赋值，则不能省略value=
	@MyAnnotation(value = "welcome", d = "d1")
	private String name;

	@MyAnnotation("hello")
	public void show(int age) {

	}

}
