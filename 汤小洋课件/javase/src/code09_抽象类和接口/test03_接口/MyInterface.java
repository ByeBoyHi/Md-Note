package code09_抽象类和接口.test03_接口;

/*
 * 定义一个接口
 */
public interface MyInterface {
	// 默认被public static final修饰
	public static final int x = 5;
	int y = 8;
	
	// 默认被public abstract修饰
	void a();
	
	public abstract void b();
	
	/*
	 * 使用default修饰的方法，可以有方法体，不强制必须实现此方法
	 * 目的：简化实现类的操作，实现类无需实现接口中的所有方法
	 */
	public default void f(){
		// System.out.println("MyInterface.f()");
	}
	
}
