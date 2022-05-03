package code11_常用类.test02_String;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 提示用户输入字符串
 * 1.统计每个字母出现的次数（忽略大小写）并输出
 * 2.统计每个数字出现的次数，存储到数组nums中
 */
public class 练习4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入字符串：");
		String str = input.nextLine();

		/*
		 * 1.统计每个字母出现的次数（忽略大小写）并输出
		 */
		char[] arr = str.toUpperCase().toCharArray();
		for (char i = 'A'; i <= 'Z'; i++) {
			int count = 0;
			for (char c : arr) {
				if (c == i) {
					count++;
				}
			}
			System.out.println("字母" + i + "出现的次数：" + count);
		}

		/*
		 * 2.统计每个数字出现的次数，存储到数组nums中
		 */
		int[] nums = new int[10];
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < str.length(); j++) {
				if ((str.charAt(j) + "").equals(i + "")) {
					nums[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
