package code04_循环结构;

import java.util.Scanner;

public class 练习5_打印直角三角形 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入行数：");
		int rows = input.nextInt();

		/*
		 * 用*打印直角三角形（1,2,3,4,5...）
		 */
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		 * 用*打印直角三角形（1,3,5,7,9...）
		 */
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		 * 用*打印倒直角三角形（...5,4,3,2,1）
		 */
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= rows - i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		/*
		 * 用*打印倒直角三角形（...9,7,5,3,1）
		 */
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= (rows - i + 1) * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

	}
}
