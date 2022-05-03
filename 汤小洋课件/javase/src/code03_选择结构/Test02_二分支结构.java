package code03_选择结构;

import java.util.Scanner;

public class Test02_二分支结构 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入您的年龄：");
		int age = input.nextInt();
		if (age >= 18) {
			System.out.println("成年");
		} else {
			System.out.println("未成年");
		}

		/*
		 * 输入两个整数a和b，如果a能被b整除或a加b大于100，则输出a，否则输出b
		 */
		System.out.print("请输入第一个整数：");
		int a = input.nextInt();
		System.out.print("请输入第二个整数：");
		int b = input.nextInt();
		if (a % b == 0 || a + b > 100) {
			System.out.println(a);
		}else{
			System.out.println(b);
		}

	}
}
