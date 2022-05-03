package code11_常用类.test05_其他类;

import java.math.BigDecimal;

public class Test03_Math {
	public static void main(String[] args) {
		/*
		 * 常量
		 */
		System.out.println(Math.PI); // 圆周率
		System.out.println(Math.E); // 自然对数

		/*
		 * 方法
		 */
		double a = 3.758;

		// round() 四舍五入
		System.out.println((int) a);
		System.out.println(Math.round(a)); // 返回long类型
		System.out.println(Math.round(a * 100) / 100.0); // 保留两位小数

		// floor() 返回小于等于参数的最大整数
		System.out.println(Math.floor(a));

		// ceil() 返回大于等于参数的最小整数
		System.out.println(Math.ceil(a));

		// abs() 绝对值
		System.out.println(Math.abs(-5));

		// pow() 求次方（幂）
		System.out.println(Math.pow(2, 5));

		// random() 产生一个[0,1)的随机浮点数
		System.out.println(Math.random());
		System.out.println((int) (Math.random() * 100)); // 产生一个[0,100)之间的随机整数
		System.out.println((int) (Math.random() * 61) + 20);// 产生一个[20,80]之间的随机整数

	}
}
