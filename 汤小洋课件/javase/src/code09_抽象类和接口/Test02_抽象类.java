package code09_抽象类和接口;

public class Test02_抽象类 {
	public static void main(String[] args) {

		// Pet pet = new Pet(); // 不允许实例化父类

		Cat cat = new Cat("猫咪");
		cat.play();
		
		Pig pig = new Pig("佩琪");
		pig.play();
	}

}

/*
 * 父类，抽象类
 */
abstract class Pet {
	String name;

	public Pet() {
		super();
	}

	public Pet(String name) {
		System.out.println("Pet.Pet(name)");
		this.name = name;
	}

	public void show() {
		// System.out.println("我是一个宠物");
	}
	
	//抽象方法
	public abstract void play();

}

class Cat extends Pet {

	public Cat() {
		super();
	}

	public Cat(String name) {
		super(name);
		System.out.println("Cat.Cat(name)");
	}

	@Override
	public void play() {
		System.out.println("正在走猫步。。。。。。");
	}
	
	

}

class Pig extends Pet {

	public Pig() {
		super();
	}

	public Pig(String name) {
		super(name);
	}

	@Override
	public void play() {
		System.out.println("正在跳泥坑。。。。。。。");
	}

}
