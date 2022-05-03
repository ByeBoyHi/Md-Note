package code18_设计模式.test01_单例模式;

/*
 * 饿汉式
 */
public class Dog {

	// 1.将构造方法私有化，不允许外部直接创建对象
	private Dog() {
		System.out.println("Dog.Dog()");
	}

	// 2.创建类的唯一实例，使用private static修饰
	private static Dog instance = new Dog();

	// 3.提供一个用于获取实例的方法，使用public static修饰
	public static Dog getInstance() {
		return instance;
	}
}
