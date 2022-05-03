package code04_循环结构;

import java.util.Scanner;

public class 练习6_打印等腰三角形 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入行数：");
		int rows = input.nextInt();
		
		for(int i=1;i<=rows;i++){
			//打印空格
			for(int k=1;k<=rows-i;k++){
				System.out.print(" ");
			}
			
			//打印*
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
