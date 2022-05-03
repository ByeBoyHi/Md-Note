package code08_三大特征.test08_多态的实现;

/*
 * 猫猫类
 */
public class Cat extends Pet {
	String breed;

	public Cat() {
		super();
	}

	public Cat(String name, String sex, String breed) {
		super(name, sex);
		this.breed = breed;
	}

	@Override
	public void show() {
		System.out.println("这是一只猫猫，名叫："+name);
	}

	@Override
	public void play() {
		System.out.println(name+"正在走猫步。。。。。。");
	}
	
	

}
