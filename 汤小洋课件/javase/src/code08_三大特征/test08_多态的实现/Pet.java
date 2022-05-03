package code08_三大特征.test08_多态的实现;

/*
 * 宠物类
 */
public class Pet {
	String name; // 宠物名
	String sex; // 性别

	public Pet() {
	}

	public Pet(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	
	public void show(){
		System.out.println("这是一只宠物");
	}
	
	public void play(){
		System.out.println("宠物正在玩耍");
	}

}
