package code09_抽象类和接口.练习2_租车系统;

import java.util.Scanner;

/*
 * 某汽车租赁公司出租各种车辆，车型及租金情况如下：
 * 1.轿车
 * 	奥迪Q3	500元/天
 * 	奥迪Q7	600元/天
 * 	宝马X3	400元/天
 * 	奥拓A1	200元/天	
 * 
 * 2.客车
 * 	金杯12座	小于等于16座，800元/天	
 * 	金龙24座  	大于16座，1200元/天
 * 
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("******************欢迎使用租车系统*********************");
		Scanner input = new Scanner(System.in);
		Customer customer = new Customer();
		MotoVehicle[] motos = new MotoVehicle[100]; // 保存租赁的车辆信息
		int i = 0; // 当前租赁的车辆索引

		System.out.print("请输入您的姓名：");
		customer.setName(input.next());
		System.out.print("请输入您的联系电话：");
		customer.setPhone(input.next());

		while (true) {
			System.out.println("--------------------------------------");
			System.out.print("请选择要租赁的车辆类型（1.轿车  2.客车  0.退出）：");
			int choice = input.nextInt();

			if (choice == 1) {
				System.out.print("请选择车辆（1.奥迪Q3 2.奥迪Q7 3.宝马X3 4.奥拓A1）：");
				int num = input.nextInt();
				switch (num) {
				case 1:
					motos[i++] = new Car("苏A11111", "奥迪", CarConstant.AUDI_Q3);
					break;
				case 2:
					motos[i++] = new Car("苏A22222", "奥迪", CarConstant.AUDI_Q7);
					break;
				case 3:
					motos[i++] = new Car("苏A33333", "宝马", CarConstant.BMW_X3);
					break;
				case 4:
					motos[i++] = new Car("苏A44444", "奥拓", CarConstant.ALTO_A1);
					break;
				}
			} else if (choice == 2) {
				System.out.print("请选择车辆（1.金杯12座  2.金龙24座）：");
				int num = input.nextInt();
				switch (num) {
				case 1:
					motos[i++] = new Bus("苏A55555", "金杯", 12);
					break;
				case 2:
					motos[i++] = new Bus("苏A66666", "金龙", 24);
					break;
				}

			} else if (choice == 0) {
				break;
			} else {
				System.out.println("输入有误！");
			}
		}

		System.out.print("请输入租赁天数：");
		int day = input.nextInt();

		System.out.println("-----------------------------------------");
		System.out.println("客户：" + customer.getName() + "，您租赁的车辆信息如下：");
		System.out.println("车牌号\t\t品牌");
		System.out.println("-----------------------------");
		double totalMoney = 0.0;
		for (int j = 0; j < i; j++) {
			totalMoney += motos[j].calcRent(day); // 累加计算租金
			System.out.println(motos[j].getNo() + "\t\t" + motos[j].getBrand());
		}
		System.out.println("-----------------------------");
		System.out.println("共租赁：" + day + "天，总租金为：" + totalMoney + "元！");

	}
}
