package code05_方法;

public class Test01_自定义方法 {
	/*
	 * main方法是程序的入口，程序在运行时会自动调用该方法
	 */
	public static void main(String[] args) {
		// 调用自定义方法
		sum();
		sum();

		sum2(50); // 50称为实参，即实际上进行运算的参数
		sum2(20);

		sum3(5, 30);
		sum3(2, 8);
	}

	/*
	 * 基本用法，无参无返回值
	 */
	public static void sum() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	/*
	 * 带一个参数的方法
	 */
	public static void sum2(int end) { // end称为形参，即形式上的参数
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	/*
	 * 带多个参数的方法
	 */
	public static void sum3(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println("从" + start + "到" + end + "的和为：" + sum);
	}

}
