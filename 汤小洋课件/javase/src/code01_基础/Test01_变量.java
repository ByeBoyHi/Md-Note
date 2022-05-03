package code01_基础;

public class Test01_变量 {
	public static void main(String[] args) {
		/*
		 * 变量的基本用法
		 */
		// 1.定义一个变量
		int age;
		// 2.为变量赋值
		age = 18;
		// 3.调用变量
		// System.out.println(age);
		System.out.println("您的年龄:" + age); // 拼接

		// 定义变量的同时为其赋值
		int num = 6;
		System.out.println(num);

		// 同时定义多个变量
		int a = 5, b = 8, c; // 以逗号隔开
		System.out.println(a);
		// System.out.println(c); //变量必须先赋值才能调用

		/*
		 * 变量的命名规范
		 */
		int aa324_$;
		int score;
		int fenshu;
		int kscj; // 考试成绩
		int studentAverageScore;
		int sCore;
		// int void; //不能使用关键字

	}
}
