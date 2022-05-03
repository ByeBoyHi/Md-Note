package code11_常用类.test02_String;

public class Test01_创建字符串 {
	public static void main(String[] args) {
		/*
		 * 1.直接创建 
		 * 该方式本身来说是不符合引用类型的特点，不符合面向对象的规范
		 * 原则上来说，所有引用类型都应该通过new关键字来创建对象，只有基本数据类型才能直接赋值
		 * String是一种特殊的引用类型，由于特别常用，所以JVM对其做了优化
		 */
		String s1 = "hello";
		char c = 'h'; // 单个字符
		String s2="h"; //只包含一个字符的字符串
		String s3=""; //空字符串
		
		/*
		 * 2.使用构造方法创建
		 */
		String s4=new String(); //空字符串
		String s5=new String("world");
		
		//空字符串和null的区别
		String s6=""; //在堆内存中分配了内存，但为空字符串
		String s7=null; //在堆内存中没有分配 空间
		
		//String可以和其他任意类型进行+的操作，实现字符串拼接
		System.out.println(s1+12+8);
		System.out.println(s1+true);
		System.out.println(s1+'x');
		
	}
}
