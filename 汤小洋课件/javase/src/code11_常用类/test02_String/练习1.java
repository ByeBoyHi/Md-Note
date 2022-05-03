package code11_常用类.test02_String;

/*
 * 将字符串进行转换
 */
public class 练习1 {
	public static void main(String[] args) {
		String str = "Hello World";

		// 转换为dlroW olleH
		String str2 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str2 += str.charAt(i);
		}
		System.out.println(str2);

		// 转换为WROLD_HELLO
		String[] arr = str.toUpperCase().split(" "); //链式写法
		String str3 = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			str3 += arr[i] + "_";
		}
		str3 = str3.substring(0, str3.length() - 1);
		System.out.println(str3);
	}
}
