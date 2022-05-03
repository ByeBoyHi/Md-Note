package code06_数组;

public class Test01_基本用法 {
	public static void main(String[] args) {
		// 1.声明数组，即定义一个数组
		int[] nums; // 推荐
		String names[];

		// 2.分配空间，指定数组大小
		nums = new int[4];

		// 3.数组赋值
		nums[0] = 13;
		nums[1] = 25;
		nums[2] = 38;
		nums[3] = 250;

		// 4.访问元素
		System.out.println("第三个元素：" + nums[2]);
		System.out.println(nums[0]);
		System.out.println(nums[3]); // 最后一个元素的下标为：数组长度-1

		System.out.println(nums); // 直接访问数组名称时会显示数组在内存中的首地址

		/*
		 * 定义数组的同时为其分配空间
		 */
		// String[] hobbies=new String[3];
		/*
		 * 定义数组的同时为其赋值
		 */
		// String[] hobbies = new String[] { "吃饭", "睡觉", "打豆豆" }; // 此时不能指定数组长度
		String[] hobbies = { "吃饭", "睡觉", "打豆豆" };
		System.out.println(hobbies[1]);
		
		/*
		 * 调用length属性获取数组长度
		 */
		System.out.println(hobbies.length);
		System.out.println(nums.length);
		System.out.println("最后一个元素："+nums[nums.length-1]);

		
		/*
		 * 数组长度一旦指定后，则无法修改，不能增加长度
		 */
		nums=new int[6];
	}
}
