package code02_运算符;

public class Test05_条件运算符 {
	public static void main(String[] args) {
		int a = 5;
		int b = 9;
		System.out.println(a * 2 < b ? "yes" : "no");

		int c = a > b ? a + b : a - b;
		System.out.println(c);
	}
}
