package code18_设计模式.test01_单例模式;

/*
 * 懒汉式
 */
public class Pig {
	
	// 1.将构造方法私有化，不允许外部直接创建对象
	private Pig() {
		System.out.println("Pig.Pig()");
	}
	
	// 2.声明类的唯一实例，但不实例化，使用private static修饰
	private static Pig instance;
	
	// 3.提供一个用于获取实例的方法，使用public static修饰
	public static Pig getInstance(){
		if(instance==null){ // 第一次访问时为空，此时创建类的唯一实例
			instance=new Pig();
		}
		return instance;
	}
	
}
