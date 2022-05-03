package code02_运算符;

public class Test02_关系运算符 {
	public static void main(String[] args) {
		int a = 5, b = 8;
		System.out.println(a > b); // 结果为boolean值
		System.out.println(a < b);
		System.out.println(a >= b);
		System.out.println(a <= b);
		System.out.println(a == b);
		System.out.println(a != b);

		// System.out.println(1<5<8); //不支持此写法

		System.out.println('x' > 'm'); // 可以用于字符的比较，比较的是字符的ascii码
	}
}
