package code11_常用类.test04_包装类;

public class Test03_基本类型和String的转换 {
	public static void main(String[] args) {
		/*
		 * 将基本类型转换为String
		 */
		int a = 9;

		// Integer.toString()
		String str = Integer.toString(a);
		System.out.println(str);
		System.out.println(a + ""); // 拼接空字符串（推荐）

		System.out.println(Integer.toBinaryString(a)); // 以2进制形式
		System.out.println(Integer.toOctalString(a)); // 以8进制形式
		System.out.println(Integer.toHexString(a)); // 以16进制形式

		/*
		 * 将String转换为基本类型
		 */
		String b = "11"; // 数值形式的字符串
		int i = Integer.parseInt(b); // 转换的是10进制数值（推荐）
		System.out.println(i);

		System.out.println(Integer.parseInt(b, 2)); // 转换的是二进制数，第二个参数表示的是进制
		System.out.println(Integer.parseInt(b, 8));
		
		int j = Integer.valueOf(a);
		System.out.println(j);
		
		/*
		 * Integer类中的常量
		 */
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
	}
}
