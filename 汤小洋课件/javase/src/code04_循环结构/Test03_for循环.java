package code04_循环结构;

import java.util.Scanner;

public class Test03_for循环 {
	public static void main(String[] args) {
		/*
		 * 输出5次HelloWorld
		 */
		for (int i = 1; i <= 5; i++) {
			System.out.println("HelloWorld");
		}

		/*
		 * 计算1-100之间不能被3整除的数之和
		 */
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 != 0) {
				sum += i;
			}
		}
		System.out.println("总和：" + sum);

		/*
		 * 循环输入五门课程的成绩，计算平均分
		 */
//		Scanner input = new Scanner(System.in);
//		sum = 0;
//		for (int j = 1; j <= 5; j++) {
//			System.out.print("请输入第" + j + "门课程的成绩：");
//			int score = input.nextInt();
//			sum += score; // 求总分
//		}
//		double avg = sum / 5.0;
//		System.out.println("平均分：" + avg);
		
		/*
		 * 初始化、条件、迭代都可以省略，但分号不能省略
		 */
		int i=1;
		for(;i<=10;i++){
			System.out.println(111);
		}

	}
}
