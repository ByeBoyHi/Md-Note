package code09_抽象类和接口;

public class Test01_final关键字 {

	static final int b = 6;
	static final int c;
	static final double PI = 3.1415926;

	static {
		c = 4; // 在静态代码块中对静态常量进行初始化
	}

	public static void main(String[] args) {
		final int a = 5; // 常量
		// a=8; //不能被修改

		Dog dog = new Dog();
		dog.sum(13, 8);
	}
}

class Animal {
	public void show() {
		System.out.println("Animal.show()");
	}

	// final修饰的方法不允许被重写
	public final void print() {
		System.out.println("Animal.print()");
	}
}

// final修饰的类不允许被继承
final class Dog extends Animal {

	@Override
	public void show() {
		System.out.println("Dog.show()");
	}

	public void sum(final int num1, int num2) {
		// num1 = 111;
		num2 = 222;
		System.out.println("Dog.sum()" + num1 + "," + num2);
	}

}