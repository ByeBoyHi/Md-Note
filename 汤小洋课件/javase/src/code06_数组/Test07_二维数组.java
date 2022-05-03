package code06_数组;

public class Test07_二维数组 {
	public static void main(String[] args) {
		/*
		 * 规则的二维数组
		 */
		// 定义二维数组
		int[][] nums;
		String names[][];

		// 分配空间
		nums = new int[3][2]; // 3表示第一维的长度，2表示第二维的长度（可以认为是3行2列，规则的）

		// 赋值
		nums[0][0] = 13;
		nums[0][1] = 4;
		nums[1][0] = 6;
		nums[1][1] = 65;
		nums[2][0] = 8;
		nums[2][1] = 14;

		// 访问元素
		// System.out.println(nums[1][0]);

		/*
		 * 定义数组的同时为其赋值
		 */
		// int[][] a = new int[][] { { 13, 4 }, { 6, 65 }, { 8, 14 } };
		int[][] a = { { 13, 4 }, { 6, 65 }, { 8, 14 } };
		// System.out.println(a.length); // 获取第一维的长度
		// System.out.println(a[0].length); // 获取第二维的长度

		// 使用二重循环遍历二维数组
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(nums[i][j] + "\t");
			}
			System.out.println();
		}

		/*
		 * 不规则的二维数组
		 */
		int[][] c = new int[4][]; // 只指定第一维的长度
		c[0] = new int[3]; // 第二维的长度有所不同
		c[1] = new int[1];
		c[2] = new int[2];
		c[3] = new int[3];
		c[0][0] = 5;
		c[0][1] = 23;
		c[0][2] = 9;
		c[1][0] = 76;
		c[2][0] = 6;
		c[2][1] = 3;
		c[3][0] = 79;
		c[3][1] = 7;
		c[3][2] = 90;
		int[][] d = { { 5, 23, 9 }, { 76 }, { 6, 3 }, { 79, 7, 90 } };

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
