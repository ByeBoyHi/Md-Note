package code07_面向对象;

import java.util.Scanner;

public class 练习_对象数组 {
	public static void main(String[] args) {
		String[] names = new String[3];

		Car[] cars = new Car[3];

		inputInfo(cars);
		
		displayInfo(cars);

		// Car car=new Car();
		// car.name="奥迪";
		// car.color="红";
		// car.speed=110;
		// cars[0]=car;
		//
		// cars[1]=new Car();
		// cars[1].name="宝马";
		// cars[1].color="黑";
		// cars[1].speed=90;
		//
		// cars[2].name="奔驰";
		// cars[2].color="白";
		//
		// System.out.println(cars[0].name);
		// System.out.println(cars[1].color);
		// System.out.println(cars[2].name);
	}

	/*
	 * 录入车辆信息
	 */
	public static void inputInfo(Car[] cars) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(); // 实例化Car对象
			System.out.println("=============请输入第" + (i + 1)
					+ "辆车的信息================");
			System.out.print("请输入车的名称：");
			cars[i].name = input.next();
			System.out.print("请输入车的颜色：");
			cars[i].color = input.next();
			System.out.print("请输入车的方向：");
			cars[i].direction = input.next();
			System.out.print("请输入车的时速：");
			cars[i].speed = input.nextInt();
			System.out.print("请输入车的价格：");
			cars[i].price = input.nextDouble();
		}

	}

	/*
	 * 显示车辆信息
	 */
	public static void displayInfo(Car[] cars) {
		System.out.println("名称\t颜色\t方向\t时速\t价格");
		System.out.println("----------------------------------------");
		for (Car car : cars) {
			System.out.println(car.name + "\t" + car.color + "\t"
					+ car.direction + "\t" + car.speed + "\t" + car.price);
		}
	}

}
