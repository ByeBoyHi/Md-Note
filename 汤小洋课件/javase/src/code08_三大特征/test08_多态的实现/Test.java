package code08_三大特征.test08_多态的实现;

public class Test {
	public static void main(String[] args) {
		Master master = new Master("唐伯虎");
		
		Dog dog = new Dog("旺财", "公", "游戏");
		master.play(dog);
		Food food=new Bone();
		food.name="骨头";
		master.feed(dog, food);
		
		Cat cat = new Cat("猫咪", "母", "波斯猫");
		master.play(cat);
		Fish fish=new Fish();
		fish.name="鱼";
		master.feed(cat, fish);
		
		Pig pig = new Pig();
		pig.name="乔治";
		master.play(pig);
	}
}
