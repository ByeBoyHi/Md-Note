package code11_常用类.test01_Object;

/*
 * 实现Cloneable接口，表示该类的对象可以被克隆
 */
public class User implements Cloneable {
	private String name;
	private int age;
	private Address address;

	public User() {
		super();
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 重写equals()
	// @Override
	// public boolean equals(Object obj) {
	// if (obj instanceof User) {
	// User user = (User) obj;
	// // 判断属性值是否相等
	// if (this.name.equals(user.name) && this.age == user.age) {
	// return true;
	// }
	// }
	// return false;
	// }

	// public String toString() {
	// System.out.println("User.toString()");
	// return "User[name=" + name + ",age=" + age + "]";
	// }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

	// 重写clone()方法
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("正在回收User.....");
		super.finalize();
	}
	
	

}
