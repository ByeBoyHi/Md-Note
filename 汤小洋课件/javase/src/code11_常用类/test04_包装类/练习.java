package code11_常用类.test04_包装类;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 一次性获取三门课程的成绩
 */
public class 练习 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请一次性输入三门课程的成绩，以空格隔开：");
		String s = input.nextLine();

		String[] arr = s.split("\\s+");
		System.out.println(Arrays.toString(arr));
		for (String str : arr) {
			int score = Integer.parseInt(str);
			System.out.println(score);
		}

	}
}
