package code03_选择结构;

import java.util.Scanner;

public class Test07_处理输入错误 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入一个整数：");
		// 判断是否输入了整数
		if (input.hasNextInt()) { // 如果输入的是整数，则返回true，否则返回false
			int num = input.nextInt();
			if (num % 2 == 0) {
				System.out.println(num + "是偶数");
			} else {
				System.out.println(num + "是奇数");
			}
		} else {
			System.out.println("输入无效！");
		}

		// System.out.println(num); //此处无法访问num
		
		
		int b = 8;
		if (true) {
			int a = 5; // 局部变量，只能在if中使用
			System.out.println(a);
			System.out.println(b);
		}
		// System.out.println(a);

	}
}
