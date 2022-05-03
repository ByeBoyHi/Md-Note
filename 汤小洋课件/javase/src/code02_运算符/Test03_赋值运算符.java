package code02_运算符;

public class Test03_赋值运算符 {
	public static void main(String[] args) {
		int a = 5;
		// a += 2; // 等价于a = a+2
		// a -= 2; // 等价于a = a-2
		// a *= 2; // 等价于a = a*2
		// a /= 2; // 等价于a = a/2
		a %= 2; // 等价于a = a%2
		System.out.println(a);

		// int b=c=6; //不支持此写法
	}
}
