package code06_数组;

import java.util.Arrays;

import code07_面向对象.Pig;

/*
 * 有一个数组[12,4,23,6,34,76,230,5]
 * 1.循环输出数组中的元素并计算所有数的总和
 * 2.将最大值放到最前面，最小值放到最后面
 */
public class 练习1 {

	public static void main(String[] args) {
		
		int[] nums = { 12, 4, 23, 6, 34, 76, 230, 5 };

		/*
		 * 1.循环输出数组中的元素并计算所有数的总和
		 */
		int sum = 0;
		for (int num : nums) {
			System.out.print(num + " ");
			sum += num;
		}
		System.out.println("\n总和：" + sum);

		/*
		 * 2.将最大值放到最前面，最小值放到最后面
		 */
		int maxIndex = 0, minIndex = 0; // 假定最大值和最小值的索引都为0
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
			if (nums[i] < nums[minIndex]) {
				minIndex = i;
			}
		}
		//交换位置nums[0] nums[maxIndex]  
		int temp=nums[0];
		nums[0]=nums[maxIndex];
		nums[maxIndex]=temp;
		
		//交换位置nums[nums.length-1] nums[minIndex]
		temp=nums[nums.length-1];
		nums[nums.length-1]=nums[minIndex];
		nums[minIndex]=temp;
		
		System.out.println(Arrays.toString(nums));
	}

	
}
