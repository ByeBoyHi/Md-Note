package code08_三大特征;

public class Test03_单继承 {
	public static void main(String[] args) {
		A a = new A();
		a.a();
		a.b();
		a.c();
		a.toString();

		C c = new C();
		c.c();
		c.toString();
		c.hashCode();
	}
}

/*
 * 如果一个类没有显式的继承其他类，那么默认继承自java.lang.Object类
 */
class C {
	public void c() {
		System.out.println("B.b()");
	}
}

class B extends C {
	public void b() {
		System.out.println("B.b()");
	}
}

class A extends B {
	public void a() {
		System.out.println("A.a()");
	}
}
