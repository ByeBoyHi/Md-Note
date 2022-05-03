package code11_常用类.test02_String;

public class Test07_常量池 {
	public static void main(String[] args) {
		/*
		 * 使用构造方法创建字符串
		 */
		// 存放在堆中，强制在堆内存中开辟一块新空间（只要是new出来的，必须会在堆中分配新的内存
		String s1 = new String("aaa");
		s1 = new String("bbb"); // 由于aaa不再被任何引用所指向，所以会gc回收

		/*
		 * 使用双引号直接创建字符串
		 */
		String s2 = "aaa"; // 字符常量，存放在常量池中
		s2 = "bbb"; // 内存的常量池中会有两个String对象，分别是aaa和bbb，且不会被gc回收

		/*
		 * 多次出现的相同字符常量，只会在常量池中创建一个String对象
		 */
		String s3 = "bbb"; // 创建流程：先判断常量池是否有bbb，如果有则直接指向常量池中的bbb，如果没有则在常量池中创建bbb
		System.out.println(s3 == s1); // false
		System.out.println(s3 == s2); // true

		String s4 = new String("bbb");
		System.out.println(s4 == s1); // false
		System.out.println(s4 == s2); // false

		// 问题1
		String s5 = "bb";
		String s6 = "b";
		String s7 = s5 + s6; // s7不是字符常量，不是使用双引号直接创建的字符串，而是在运行时计算得到的
		System.out.println(s7 == s2); // false

		// 问题2
		String s8 = "bb" + "b"; // s8是字符常量，对于常量和常量的运算，在编译期已经得到了值（编译器做了优化）
		System.out.println(s8 == s2); // true

		// 问题3
		String s9 = s5 + "b"; //s9不是字符常量，在编译期无法确定s9的值
		System.out.println(s9==s2); //false
		
		// 问题4：共创建了多少个对象？ 9个

	}
}
