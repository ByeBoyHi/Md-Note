package code06_数组;

import java.util.Arrays;

public class Test03_增强for循环 {
	public static void main(String[] args) {
		int[] nums = { 3, 12, 67, 2, 65, 32, 9 };

		// 普通的for循环
		for (int i = 0; i < 5; i++) {
			System.out.println(nums[i]);
		}
		System.out.println();

		// 增强for循环
		for (int n : nums) {
			System.out.println(n);
		}
		
		//Arrays类的toString()方法，将数组转换为字符串
		System.out.println(Arrays.toString(nums)); //数组元素以逗号隔开，放到中括号里
	}
}
