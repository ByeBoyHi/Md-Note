package code06_数组;

import java.util.Arrays;

public class Test09_Arrays工具类 {
	public static void main(String[] args) {
		int[] nums = { 14, 2, 54, 24, 120, 34, 6 };
		
		/*
		 * toString() 将数组转换字符串
		 */
		System.out.println(Arrays.toString(nums));
		
		/*
		 * sort() 排序
		 */
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		/*
		 * fill() 填充
		 */
		Arrays.fill(nums, 0);
		System.out.println(Arrays.toString(nums));
		
	}
}
