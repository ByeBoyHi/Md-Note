package code05_方法;

public class Test02_方法的返回值 {
	public static void main(String[] args) {
		int result = sum(5, 38); // 调用方法并接收返回值，保存到变量中
		System.out.println(result * 2 + 1);
		System.out.println(result / 2);

		System.out.println(m(35));
	}

	/*
	 * 带返回值的方法
	 */
	public static int sum(int num1, int num2) {
		int result = 0;
		for (int i = num1; i <= num2; i++) {
			result += i;
		}
		return result; // 使用return返回方法执行后的结果
	}

	public static String m(int age) {
		// if (age >= 18) {
		// return "成年";
		// } else {
		// return "未成年";
		// }
		if (age >= 18) {
			return "成年";
		} 
		return "未成年";
	}
	
	/*
	 * return关键字的作用：
	 * 1.返回方法执行后的结果
	 * 2.结束方法的执行
	 */
	public static void calc(int x){
		if(x%2==0){
			return; //方法立即执行结束
		}
		System.out.println(x);
	}
	
}
