package code06_数组;

import java.util.Arrays;

public class Test06_值传递和引用传递 {
	public static void main(String[] args) {
		/*
		 * 基本数据类型
		 */
		int a = 5;
		int b = a; // 将a的值传递给b
		b = 8;
		System.out.println(a);
		System.out.println(b);

		/*
		 * 引用数据类型
		 */
		int[] c = { 12, 4, 23, 7 };
		int[] d = c; // 将c的内存地址传递给d，本质上指向同一块内存空间
		d[0] = 666;
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));

		/*
		 * 方法传参，与变量赋值是相同的
		 */
		change(a,c);
		System.out.println(a);
		System.out.println(Arrays.toString(c));

	}

	public static void change(int i, int[] array) {
		i = 111;
		array[array.length - 1] = 222;
	}
}
