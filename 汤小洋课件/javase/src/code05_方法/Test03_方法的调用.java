package code05_方法;

/*
 * 在同一个类中，直接使用方法名()
 * 在不同类中，需要使用类名.方法名()
 */
public class Test03_方法的调用 {
	public static void main(String[] args) {
		// m2();

		System.out.println(Test02_方法的返回值.sum(4, 7));

		// Java提供了Math类
		int a = 12;
		int b = 7;
		System.out.println(Math.max(a, b));
		System.out.println(Math.min(a, b));
		System.out.println(Math.random()); //随机生成[0,1)之间的随机数
		//随机生成[1,100)之间的随机整数
		System.out.println((int)(Math.random()*99)+1); //[1,100)
		//随机生成[20,100]之间的随机整数
		System.out.println((int)(Math.random()*81)+20); //[20,100]
		
	}

	public static void m1() {
		System.out.println("Test03_方法的调用.m1()");
	}

	public static void m2() {
		System.out.println("Test03_方法的调用.m2()");
		m1();
	}
}
