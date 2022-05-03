package code08_三大特征.test08_多态的实现;

/*
 * 狗狗类
 */
public class Dog extends Pet {
	String hobby;

	public Dog() {
		super();
	}

	public Dog(String name, String sex, String hobby) {
		super(name, sex);
		this.hobby = hobby;
	}

	@Override
	public void show() {
		System.out.println("这是一只狗狗，名叫：" + name);
	}

	@Override
	public void play() {
		System.out.println(name + "正在接飞盘。。。。。。");
	}

}
