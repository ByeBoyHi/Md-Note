package code02_运算符;

public class Test01_算术运算符 {
	public static void main(String[] args) {
		/*
		 * 基本用法
		 */
		int a = 5;
		int b = 2;
		// int sum = a + b;
		// System.out.println("a+b=" + sum);

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		System.out.println("-------------------------------");

		/*
		 * 自增自减
		 */
		int c = 6;
		// c++;
		// ++c;
		// c--;
		--c;
		System.out.println(c);

		/*
		 * 前缀自增自减和后缀自增自减的区别
		 */
		int x = 3;
		// System.out.println(++x); //先加1，再输出
		System.out.println(x++); // 先输出，再加1

		int m = 5;
		// int n = m--;
		int n = --m;
		System.out.println(n);

		// 思考？
		int i = 3;
		int j = (i++) + (++i);
		System.out.println(j);

		/*
		 * 将字符串与数值相加时会进行拼接
		 */
		System.out.println("hello" + 33 + 55);
		System.out.println("hello" + (33 + 55));
		int d = 3, e = 8;
		System.out.println("" + d + e); // 借助空字符串，实现将数字拼接
		
	}
}
