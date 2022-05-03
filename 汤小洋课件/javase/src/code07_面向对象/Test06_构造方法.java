package code07_面向对象;

public class Test06_构造方法 {
	public static void main(String[] args) {
		// Dog dog = new Dog();
		// dog.name = "旺财";
		// dog.age = 2;
		// dog.breed = "金毛";
		// dog.run();
		// dog.show();
		// System.out.println("--------------------");

		Dog dog2 = new Dog("小花", 3, "拉布拉多");
		dog2.run();
		dog2.show();
	}
}

class Dog {
	// 成员属性
	String name;
	int age;
	String breed; // 品种

	// 成员方法
	public void run() {
		System.out.println("狗狗正在奔跑。。。。。");
	}

	public void show() {
		System.out.println("姓名：" + name + "，狗龄：" + age + "，品种：" + breed);
	}

	// 构造方法
	public Dog() {
		System.out.println("无参的构造方法。。。。。。");
	}

	// 带参构造方法
	public Dog(String name, int age) {
		this();
		this.name = name;
		this.age = age;
		System.out.println("带两个参数的构造方法。。。。。。");
	}

	public Dog(String name, int age, String breed) {
		this(name, age); //调用另一个构造方法，必须位于第一行
		this.breed = breed;
		System.out.println("带三个参数的构造方法。。。。。。");
	}
}
