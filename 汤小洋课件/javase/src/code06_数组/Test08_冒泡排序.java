package code06_数组;

import java.util.Arrays;

public class Test08_冒泡排序 {
	public static void main(String[] args) {
		int[] nums = { 14, 2, 54, 24, 120, 34, 6 };

		// 外层循环控制比较的轮数
		for (int i = 0; i < nums.length - 1; i++) {
			// 内层循环控制每一轮比较的次数
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
			System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(nums));
		}

		System.out.println("排序后的数组：" + Arrays.toString(nums));
	}
}
