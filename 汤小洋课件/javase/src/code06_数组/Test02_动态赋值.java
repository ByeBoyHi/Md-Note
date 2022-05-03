package code06_数组;

import java.util.Scanner;

public class Test02_动态赋值 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/*
		 * 循环接收用户输入的数据，为数组赋值
		 */
		String[] names = new String[5];
		for (int i = 0; i < names.length; i++) {
			System.out.print("请输入第" + (i + 1) + "个学生的姓名：");
			names[i] = input.next();
		}

		/*
		 * 循环输出数组中的元素
		 */
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
