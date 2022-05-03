package code06_数组;

public class Test04_默认值 {
	public static void main(String[] args) {
		/*
		 * 局部变量是没有默认值的
		 */
		// int age;
		// System.out.println(age);

		/*
		 * 数组中元素是有默认值的
		 */
		int[] nums = new int[3];
		double[] heights = new double[3];
		boolean[] flags = new boolean[3];
		String[] names = new String[3];

		System.out.println(nums[1]); // 0
		System.out.println(heights[1]); // 0.0
		System.out.println(flags[1]); // false
		System.out.println(names[1]); // null
	}
}
