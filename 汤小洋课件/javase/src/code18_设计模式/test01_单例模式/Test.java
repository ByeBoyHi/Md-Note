package code18_设计模式.test01_单例模式;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
//		System.out.println(new Dog());
//		System.out.println(new Dog());
		
//		System.out.println(Dog.getInstance());
//		System.out.println(Dog.getInstance());
//		System.out.println(Dog.getInstance());
//		System.out.println(Dog.getInstance());
		
		//Class.forName("code20_设计模式.test01_单例模式.Dog"); //加载类
		
		System.out.println(Pig.getInstance());
		System.out.println(Pig.getInstance());
	}
}
