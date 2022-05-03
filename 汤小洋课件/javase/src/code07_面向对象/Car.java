package code07_面向对象;

/*
 * 汽车类（型）
 */
public class Car {
	// 属性（特征）
	String name;
	String color;
	String direction;
	int speed;
	double price;

	// 方法（行为）
	public void run() {
		System.out
				.println(name + "正在以" + speed + "的时速向" + direction + "行驶。。。。");
	}
}
