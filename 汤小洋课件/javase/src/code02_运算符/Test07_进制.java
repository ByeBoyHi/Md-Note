package code02_运算符;

public class Test07_进制 {
	public static void main(String[] args) {
		/*
		 * 在Java中可以通过不同的进制来表示整数，但在打印输出时都是以十进制的形式显示的
		 */
		int a = 10;
		int b = 0b10; // 二进制以0b开头
		int c = 010; // 八进制以0开头
		int d = 0X10; // 十六进制以0x开头

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		/*
		 * 计算机内部是使用补码来存储和表示值
		 */
		System.out.println(0b00000000000000000000000000000101);
		System.out.println(0b11111111111111111111111111111011);
		
		
	}
}
