package code02_运算符;

public class Test04_逻辑运算符 {
	public static void main(String[] args) {
		boolean a = true, b = false;
		System.out.println(a && b); // 两个都为true，则为true，否则为false
		System.out.println(a || b); // 只要有一个为true，则为true，否则为false
		System.out.println(!b); // 如果为true，则为false；如果为false，则为true

		System.out.println(5 > 2 && 8 <= 6);
		System.out.println(16 > (4 + 2) * 3);
		System.out.println(!(5 > 8));

		/*
		 * 逻辑运算是一种短路运算 
		 * 对于&&，如果左边为false，则不再执行右边代码
		 * 对于||，如果左边为true，则不再执行右边代码
		 */
		// System.out.println(false && (5 + 2) * 3 > 15);

		// System.out.println(5 / 0); //除数不能为零

		System.out.println(false && 5 / 0 > 3);
		System.out.println(true || 5 / 0 > 3);
	}
}
