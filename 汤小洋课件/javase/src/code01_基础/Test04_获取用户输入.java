package code01_基础;

//1.导入Scanner，否则无法使用Scanner
import java.util.Scanner;

public class Test04_获取用户输入 {
	public static void main(String[] args) {
		// 2.创建一个Scanner对象，名称为input
		Scanner input = new Scanner(System.in);
		// 3.使用Scanner获取输入数据
		System.out.print("请输入您的姓名："); // 提示用户输入数据
		String name = input.next(); // 使用next()获取字符串，将数据存储到变量中
		System.out.print("请输入您的年龄：");
		int age = input.nextInt(); // 使用nextInt()获取整数
		System.out.print("请输入您的身高："); // 使用nextDouble()获取小数
		double height = input.nextDouble();

		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
		System.out.println("身高：" + height);
	}
}
