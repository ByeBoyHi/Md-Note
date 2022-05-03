package code06_数组;

public class Test05_常见错误 {
	public static void main(String[] args) {
	int[] nums = new int[5];

	/*
	 * ArrayIndexOutOfBoundsException 数组下标越界异常 
	 * 原因：下标大于等于数组长度 或 小于0
	 */
	System.out.println(nums[2]);

	/*
	 * 不支持以下写法
	 */
	// int[] scores=new int[5];
	// scores={12,5,234,2};
	}
}
