package code11_常用类.test02_String;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Test04_字符集 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		test03();
	}

	// 查看字符集
	public static void test01() {
		System.out.println("当前系统使用的字符集：" + System.getProperty("file.encoding"));
		System.out.println("当前JVM使用的字符集：" + Charset.defaultCharset()); // JVM默认使用当前操作系统的字符集
	}

	// 编码和解码
	public static void test02() throws UnsupportedEncodingException {
		String s = "您好";

		/*
		 * 编码
		 */
		byte[] bytes = s.getBytes("gbk"); // 对于GBK，一个汉字占2个字节
		// byte[] bytes = s.getBytes("utf-8"); //对于UTF-8，一个汉字占3个字节
		System.out.println(Arrays.toString(bytes));

		/*
		 * 解码
		 */
		// String str = new String(bytes, "gbk");
		String str = new String(bytes);
		System.out.println(str);
	}

	// 乱码
	public static void test03() throws UnsupportedEncodingException {
		String s = "您好";

		// 1.编码——>正确
		byte[] bytes = s.getBytes("gbk");
		System.out.println(Arrays.toString(bytes));

		// 2.解码——>错误
		String str = new String(bytes, "iso8859-1");
		System.out.println(str);

		// 3.重新编码
		// byte[] bytes2 = str.getBytes("iso8859-1");
		// System.out.println(Arrays.toString(bytes2));

		// 4.重新解码
		// String str2 = new String(bytes2,"gbk");
		// System.out.println(str2);
		
		String str2 = new String(str.getBytes("iso8859-1"),"gbk");
		System.out.println(str2);
		
		/*
		 * 如果编码不正确，则无论如何解码都没用
		 */
		bytes = s.getBytes("iso8859-1");
		str = new String(bytes,"iso8859-1");
		System.out.println(str);
		
	}

}
