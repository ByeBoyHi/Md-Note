package code07_面向对象;

public class Test05_方法重载overload {
	public static void main(String[] args) {
		Calculator c = new Calculator();

		// 调用时会根据传递的参数的不同调用相应的重载方法
		System.out.println(c.sum(3, 5));
		System.out.println(c.sum(3, 5, 2));
		System.out.println(c.sum(3, 5.8));
		System.out.println(c.sum(5.8, 3));
		
		System.out.println(111);
		System.out.println("aaa");
		System.out.println('a');
		System.out.println(true);
	}
}

/*
 * 计算器类
 */
class Calculator {
	/*
	 * 方法重载
	 */
	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}

	public double sum(int num1, double num2) {
		return num1 + num2;
	}

	public double sum(double num1, int num2) {
		return num1 + num2;
	}
}