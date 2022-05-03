package code01_基础;

/*
 * 交换两个变量的值
 */
public class 练习 {
	public static void main(String[] args) {
		int a = 3;
		int b = 8;
		System.out.println("交换前的值");
		System.out.println("a=" + a);
		System.out.println("b=" + b);

		/*
		 * 通过第三个变量交换
		 */
		// int c=a; //3
		// a=b; //8
		// b=c; //3

		/*
		 * 不通过第三个变量
		 */
		a = a + b; // 11
		b = a - b;// 3
		a = a - b;// 8

		System.out.println("交换后的值");
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
}
