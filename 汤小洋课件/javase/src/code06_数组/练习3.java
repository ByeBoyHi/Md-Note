package code06_数组;

import java.util.Arrays;

/*
 * 自定义方法，实现对数组的操作
 */
public class 练习3 {

	// 实现复制数组的功能，需要两个参数：源数组、目标数组
	public static void copyArray(int[] src, int[] dst) {
		for (int i = 0; i < src.length; i++) {
			dst[i] = src[i];
		}
	}

	// 实现输出数组中的元素，以短横线分隔
	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				System.out.print(array[i] + "-");
			} else {
				System.out.println(array[i]);
			}
		}
	}

	// 实现倒序输出数组中的元素
	public static void print(int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}

	// 实现交换数组中两个元素的功能
	public static void changeArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// 实现将数组中的元素反转
	public static void reverseArray(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			int j = array.length - 1 - i;
			changeArray(array, i, j); // 交换位置
		}
	}

	public static void main(String[] args) {
		int[] nums = { 34, 6, 23, 7, 3, 65, 9 };

		// int[] nums2 = new int[nums.length];
		// copyArray(nums, nums2);
		// System.out.println(Arrays.toString(nums));

		// show(nums);

		// print(nums);

		// changeArray(nums, 0, nums.length - 1);
		// System.out.println(Arrays.toString(nums));

		reverseArray(nums);
		System.out.println(Arrays.toString(nums));

	}

}
