package code11_常用类.test01_Object;

public class Test {
	public static void main(String[] args) throws CloneNotSupportedException {
		// getClassTest();
		// equalsTest();
		// hashCodeTest();
		// toStringTest();

		// cloneTest();

		finalizeTest();
	}

	public static void objectTest() {
		// 所有类都继承自Object类，即继承了Object类中的成员
		User user = new User();

		user.toString();
		user.hashCode();
	}

	// getClass()
	public static void getClassTest() {
		User user = new User();

		Class c = user.getClass(); // 返回的是Class对象，表示的是运行时类
		System.out.println(c);

		User u = new VIPUser();
		System.out.println(u.getClass()); // 运行时类为VIPUser

		// 判断对象的类型
		// if(u instanceof VIPUser){
		if (u.getClass() == VIPUser.class) { // 通过 类名.class属性 也可以获取类 的Class对象
			// VIPUser vu = (VIPUser)u;
			// vu.show();
			((VIPUser) u).show();
		}

	}

	// equals()
	public static void equalsTest() {
		User u1 = new User("tom", 18);
		User u2 = new User("jack", 18);

		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));

	}

	// hashCode()
	public static void hashCodeTest() {
		User u1 = new User("tom", 18);
		User u2 = new User("jack", 18);

		System.out.println(u1.hashCode());
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());

		System.out.println(Integer.toHexString(u1.hashCode())); // 转换为十六进制的hashCode值

	}

	// toString()
	public static void toStringTest() {
		User u1 = new User("tom", 18);

		// System.out.println(u1.toString());
		System.out.println(u1);

	}

	// clone()
	public static void cloneTest() throws CloneNotSupportedException {
		User u1 = new User("tom", 18);
		u1.setAddress(new Address("江苏", "南京"));

		// 只克隆u1对象，所用的address对象并没有克隆，仍然指向原来的u1的address
		User u2 = (User) u1.clone();

		u2.setName("jack");
		u2.getAddress().setCity("扬州");

		System.out.println(u1);
		System.out.println(u2);

		System.out.println(u1.getAddress() == u2.getAddress());
	}

	// finalize()
	public static void finalizeTest() {
		User u1 = new User();
		u1 = null;
		
		// 建议gc进行垃圾回收
		System.gc();
		
		while(true){
			
		}
	}

}
