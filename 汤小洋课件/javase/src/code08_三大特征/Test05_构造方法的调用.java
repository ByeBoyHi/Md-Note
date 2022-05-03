package code08_三大特征;

public class Test05_构造方法的调用 {
	public static void main(String[] args) {
		// Pig pig = new Pig("佩琪", "女", 2, 85.7);
		Pig pig = new Pig();
		
		pig.show();
	}
}

/*
 * 父父类
 */
class Live {
	public Live() {
		System.out.println("父父类中无参的构造方法。。。。。");
	}
}

/*
 * 父类
 */
class Animal extends Live {
	String name = "李四";
	String sex;

	public Animal() {
		System.out.println("父类中无参的构造方法。。。。。");
	}

	public Animal(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
		System.out.println("父类中带参的构造方法。。。。。");
	}

	
	public void show() {
		System.out.println("父类中的show方法。。。。。");
	}
}

/*
 * 子类
 */
class Pig extends Animal {
	int age;
	double weight;

	String name = "张三";

	public Pig() {
		System.out.println("子类中无参的构造方法。。。。。");
	}

	public Pig(int age, double weight) {
		super(); // 调用父类中无参的构造方法
		this.age = age;
		this.weight = weight;
		System.out.println("子类中带两个参数的构造方法。。。。。");
	}

	public Pig(String name, String sex, int age, double weight) {
		// this(age, weight);
		// this.name = name;
		// this.sex = sex;
		super(name, sex);
		this.age = age;
		this.weight = weight;
		System.out.println("子类中带四个参数的构造方法。。。。。");
	}

	public void show() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(name);
		// System.out.println(this.name);
		 System.out.println(super.name);

		super.show();
	}
}
