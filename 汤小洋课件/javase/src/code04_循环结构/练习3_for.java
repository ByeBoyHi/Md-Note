package code04_循环结构;

import java.util.Scanner;

/*
 * 任意输入一个整数，根据这个值输出加法表
 * 假设输入的是5，则输出：
 * 0+5=5
 * 1+4=5
 * 2+3=5
 * 3+2=5
 * 4+1=5
 * 5+0=5
 */
public class 练习3_for {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入任意一个整数：");
		int num = input.nextInt();
		for (int i = 0; i <= num; i++) {
			System.out.println(i + "+" + (num - i) + "=" + num);
		}
	}

}
