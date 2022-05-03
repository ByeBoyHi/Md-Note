package code08_三大特征.test08_多态的实现;

public class Pig extends Pet {

	public Pig() {

	}

	public Pig(String name, String sex) {
		super(name, sex);
	}

	@Override
	public void show() {
		System.out.println("这是一只猪猪，名叫：" + super.name);
	}

	@Override
	public void play() {
		System.out.println(name + "正在跳泥坑。。。。。。");
	}

}
