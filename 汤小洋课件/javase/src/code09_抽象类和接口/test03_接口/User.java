package code09_抽象类和接口.test03_接口;

public class User extends Person implements MyInterface,IUser {

	public void a() {
		System.out.println("User.a()");
	}

	@Override
	public void b() {
		System.out.println("User.b()");
	}

	@Override
	public void c() {
		System.out.println("User.c()");
	}

	@Override
	public void d() {
		System.out.println("User.d()");
	}

	@Override
	public void e() {
		System.out.println("User.e()");
	}
}
