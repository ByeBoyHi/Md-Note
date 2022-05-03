package code01_基础;

public class Test03_类型转换 
{
	public static void main(String[] args) 
	{
		/*
		 * 自动类型转换，也称为隐式转换
		 */
		int a=3;
		long b=a;
		double c=a;
		double d=a+2.5;
		System.out.println(c);
		System.out.println(d);
		
		/*
		 * 强制类型转换，也称为显式转换
		 */
		double e=12.6;
		int f=(int)e;
		System.out.println(f);
		
		// String g="welcome";
		// int h=(int)g;
		
		/*
		 * char和int之间的转换
		 */
		//将char转换为int
		int x='a'; //隐式转换
		System.out.println(x);
		
		//将int转换为char
		char y=(char)x; //必须进行强制类型转换
		System.out.println(y);
		char z=97; //不会报错，97被当作常数来处理，而非整型int（整数和整型是有所不同的）
		System.out.println(z);
		
		
		
		
	}
}
