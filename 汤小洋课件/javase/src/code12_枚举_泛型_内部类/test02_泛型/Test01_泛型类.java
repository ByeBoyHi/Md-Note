package code12_枚举_泛型_内部类.test02_泛型;

public class Test01_泛型类 {
	public static void main(String[] args) {

		// 可以为Student类指定任意一种属性，一旦指定后则不能再修改属性的种类，但可以修改值
		Student student = new Student();
		// student.name = "tom";
		// student.age=20;
		// student.height=180.5;
		student.field = 20;
		student.field="tom"; // 可以任意赋值，缺乏类型安全

		// 在使用类时需要在类名通过<类型>指定具体的类型
		Stu<String> stu=new Stu<>();
		//stu.field=20;
		//stu.field="tom"; // 类型安全
		stu.field="tom"; //field为String类
		// stu.field=180.5; 
		System.out.println(stu.field.getClass());
	}
}

/*
 * 普通类
 */
class Student {
	// 在没有出现泛型之前是通过Object来实现，但Object缺乏类型安全，Java引入泛型的好处：安全、简单
	public Object field;

}

/*
 * 泛型类
 */
class Stu<T>{ //T表示一种类型，但暂时不知道具体的类型，称为参数化类型，在使用该类时要使用具体的类型
	T field;
}





