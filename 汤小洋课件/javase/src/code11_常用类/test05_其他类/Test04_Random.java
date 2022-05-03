package code11_常用类.test05_其他类;

import java.util.Random;

public class Test04_Random {
	public static void main(String[] args) {
		// 创建一个Random实例，随机数生成器
		Random r = new Random();

		/*
		 * 常用方法
		 */
		// nextInt() 生成一个随机整数
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(100)); // 生成一个[0,100)之间的随机整数
		System.out.println(r.nextInt(61) + 20);// 产生一个[20,80]之间的随机整数

		// nextDouble 生成一个[0,1)之间的随机浮点数，相当于Math.random()
		System.out.println(r.nextDouble());

		// nextBoolean() 生成一个随机布尔值
		System.out.println(r.nextBoolean());
		
		System.out.println(Math.random()>0.5?true:false);
	}
}
