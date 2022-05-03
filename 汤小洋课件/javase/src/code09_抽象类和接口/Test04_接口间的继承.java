package code09_抽象类和接口;
/*
 * 类、接口的关系
 * 1.类与类之间
 * 	一个类可以继承自另一个类： class 子类 extends 父类
 * 2.接口与接口之间
 *  一个接口可以继承自多个接口：interface 子接口 extends 父接口1,父接口2
 * 3.类与接口之间
 * 	一个类可以实现多个接口：class 实现类 implements 接口1,接口2 
 */
public class Test04_接口间的继承 {
	public static void main(String[] args) {
		D d = new D();
		d.a();
		d.b();
		d.c();
	}
}

interface A{
	public void a();
}

interface B{
	public void b();
}

interface C extends A,B{
	public void c();
}

class D implements C{

	@Override
	public void a() {
		System.out.println("D.a()");
	}

	@Override
	public void b() {
		System.out.println("D.b()");
	}

	@Override
	public void c() {
		System.out.println("D.c()");
	}
	
}