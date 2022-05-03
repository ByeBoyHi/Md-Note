package code07_面向对象;

public class Test08_访问修饰符 {
	public static void main(String[] args) {
		Pig pig = new Pig();

		// 同包中的不同类
		System.out.println(pig.s1);
		System.out.println(pig.s2);
		System.out.println(pig.s3);
		// System.out.println(pig.s4);
	}
}

