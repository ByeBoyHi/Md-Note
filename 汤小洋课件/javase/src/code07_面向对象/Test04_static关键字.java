package code07_面向对象;

public class Test04_static关键字 {
	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.name = "tom";
		System.out.println(stu1.name);

		// stu1.hobby="吃饭";
		Student.hobby = "睡觉"; // 推荐

		// System.out.println(Student.hobby);

		Student stu2 = new Student();
		stu2.name = "jack";
		Student.hobby = "编程";

		System.out.println(stu2.name);

		System.out.println(stu1.hobby);

		stu1.show();

		// stu2.print();
		Student.print(); // 推荐

	}
}

/*
 * 学生类
 */
class Student {
	String name; // 实例变量
	static String hobby; // 静态变量(类变量)

	// 实例方法
	public void show() {
		System.out.println("实例方法show");
		System.out.println("姓名：" + name);
		System.out.println("爱好：" + hobby); // 实例方法中可以访问静态变量
	}

	// 静态方法
	public static void print() {
		System.out.println("静态方法print。。。。");
		// System.out.println(name); //静态方法中不能访问实例变量
		System.out.println(hobby);
		// show(); //静态方法中不能访问实例方法
	}

}
