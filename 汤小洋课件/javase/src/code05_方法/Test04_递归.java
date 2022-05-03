package code05_方法;

public class Test04_递归 {
	public static void main(String[] args) {
		// System.out.println(calc(2, 5));
		// System.out.println(calc(2, 0));
		dg(5);
	}

	/*
	 * 计算x的y次方，如2的5次方
	 */
	public static int calc(int x, int y) {
		// 常规实现方法
		// if (y == 0) {
		// return 1;
		// }
		// int result = x;
		// for (int i = 1; i < y; i++) {
		// result = result * x;
		// }
		// return result;

		if (y == 0) {
			return 1;
		}
		return x * calc(x, y - 1);
	}
	
	/*
	 * 注意：
	 * 1.必须有退出条件，否则可能会出现死循环
	 * 2.此时会报错
	 */
	public static void dg(int n){
		System.out.println(1111);
		if(n<1){
			return;
		}
		dg(n-1);
	}
	
}
