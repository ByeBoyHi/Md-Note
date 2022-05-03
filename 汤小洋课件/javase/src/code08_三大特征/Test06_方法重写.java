package code08_三大特征;

public class Test06_方法重写 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "旺财";
		dog.cry(); // 调用的是子类重写后的方法

		Cat cat = new Cat();
		cat.name = "猫咪";
		cat.cry();
	}
}

/*
 * 父类
 */
class Pet {
	String name;
	String sex;
	int health;

	public void cry() {
		System.out.println("俺是宠物，俺能叫。。。。。");
	}
	
	public int sum(int num1,int num2){
		return num1+num2;
	}
	
	protected Pet show(){
		System.out.println("我是一只宠物");
		return new Pet();
	}
}

class Dog extends Pet {
	String hobby;

	// 重写父类中的方法
	public void cry() {
		System.out.println("俺是狗，旺旺旺。。。。");
	}
}

class Cat extends Pet {

	@Override
	// 该注解表示当前方法是一个重写方法，可有可无
	public void cry() {
		System.out.println("俺是猫，喵喵喵。。。。。");
	}

	@Override
	public Cat show() {
		System.out.println("我是一只猫");
		return new Cat();
	}
	
	@Override
	public int sum(int num1, int num2) {
		
		return super.sum(num1, num2);
	}
}
