package code08_三大特征.test08_多态的实现;

/*
 * 主人类
 */
public class Master {
	String name;

	public Master() {
		super();
	}

	public Master(String name) {
		super();
		this.name = name;
	}

	// 与宠物玩耍
	public void play(Pet pet) { //将父类的引用作为方法形参，减少代码，更具有扩展性
		pet.play();
	}

	// 喂养宠物
	public void feed(Pet pet, Food food) {
		System.out.println("给" + pet.name + "喂养" + food.name);
	}

}
