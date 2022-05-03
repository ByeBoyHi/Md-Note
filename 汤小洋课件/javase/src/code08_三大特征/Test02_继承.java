package code08_三大特征;

public class Test02_继承 {
	public static void main(String[] args) {
		Pupil s1 = new Pupil("tom", 8, "male", "小猪佩琪");
		// s1.name="tom";
		s1.show();
		s1.watch();

		Middle s2 = new Middle("jack", 14, "male", "王者农药");
		s2.show();
		s2.play();
	}
}

/*
 * 学生类
 */
class Student {
	String name;
	int age;
	String sex;

	public void show() {
		System.out.println("我是一个学生，姓名：" + name + "，年龄：" + age + "，性别：" + sex);
	}
}

/*
 * 小学生类
 */
class Pupil extends Student {
	String cartoon; // 动画片

	public Pupil() {

	}

	public Pupil(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public Pupil(String name, int age, String sex, String cartoon) {
		this(name, age, sex);
		this.cartoon = cartoon;
	}

	public void watch() {
		System.out.println("正在看动画片：" + cartoon);
	}
}

/*
 * 中学生类
 */
class Middle extends Student {
	String game; // 游戏

	public Middle(String name, int age, String sex, String game) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.game = game;
	}

	public void play() {
		System.out.println("正在玩游戏：" + game);
	}
}

/*
 * 大学生类
 */
class College extends Student {
	String lover; // 爱人

	public void love() {
		System.out.println("正在谈恋爱：" + lover);
	}
}
