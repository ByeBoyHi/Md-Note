package code02_运算符;

public class Test08_位运算符 {
	public static void main(String[] args) {
		int a = 5; // 二进制为00000000 00000000 00000000 00000101
		int b = 8; // 二进制为00000000 00000000 00000000 00001000

		// 与：两位都为1，则为1，否则为0
		System.out.println(a & b); // 00000000
		// 或：只要有一个1，则为1，否则为0
		System.out.println(a | b); // 00001101
		// 非：如果为1，则为0，如果为0，则为1
		System.out.println(~a); // 11111111 11111111 11111111 11111010 
		//异或：如果两位相同，则为0，否则为1
		System.out.println(a^b); //00001101
		//左移：将二进制的所有位都向左移指定的位数，末尾补0
		System.out.println(a<<2); //00010100
		//右移：将二进制的所有位都向右移指定的位数，高位补符号位
		System.out.println(a>>2); //00000001
		//无符号右移：将二进制的所有位都向右移指定的位数，高位补0
		System.out.println(a>>>2);

	}
}
