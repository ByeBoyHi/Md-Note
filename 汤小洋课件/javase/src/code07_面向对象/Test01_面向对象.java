package code07_面向对象;

/*
 * 记录马路上的汽车信息
 */
public class Test01_面向对象 {
	public static void main(String[] args) {
		/*
		 * 记录一辆车的信息，缺点：变量太多
		 */
		String name = "大众POLO";
		String color = "红";
		String direction = "东";
		int speed = 110;
		double price = 35.2;

		/*
		 * 记录多辆车的信息，缺点：信息分散
		 */
		String[] names = new String[3];
		String[] colors = new String[3];
		String[] directions = new String[3];
		int[] speeds = new int[3];
		double[] prices = new double[3];
		names[0] = "北京现代";
		colors[0] = "白";
		directions[0] = "西";
		speeds[0] = 95;
		prices[0] = 16.3;
		names[1] = "奥迪";
		colors[1] = "黑";

		/*
		 * 使用面向对象来记录车辆信息
		 */
		Car car1 = new Car(); // 创建一个Car对象
		car1.name = "奥迪"; // 为属性赋值
		car1.color = "黑";
		car1.direction = "南";
		car1.speed = 120;
		car1.price = 45.8;

		Car car2; // 创建Car对象的引用
		car2 = new Car(); // 创建一个Car对象，car2指向此对象
		car2.name = "宝马";
		car2.color = "白";
		car2.direction = "东";
		car2.speed = 78;
		car2.price = 29.6;

		System.out.println(car1.name); //调用对象的属性
		System.out.println(car1.speed);
		System.out.println(car2.price);
		
		car1.run(); //调用对象的方法
		car2.run();

	}
}
