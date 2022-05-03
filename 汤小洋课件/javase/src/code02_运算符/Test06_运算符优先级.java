package code02_运算符;

public class Test06_运算符优先级 {
	public static void main(String[] args) {
		int a = 4, b = 12;

		System.out.println(5 + 2 * 3 >= 7 + a++);
		System.out.println(5 + 2 > 4 && 8 > 3 || 3 < 2);
		System.out.println(((3+2) * --a -17%2<24) || (b/3==15 &&b!=a*3));
	}
}
