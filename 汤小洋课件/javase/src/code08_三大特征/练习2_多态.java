package code08_三大特征;

import java.util.Scanner;
import code08_三大特征.test08_多态的实现.Dog;
import code08_三大特征.test08_多态的实现.Pet;
import code08_三大特征.test08_多态的实现.Cat;
import code08_三大特征.test08_多态的实现.Pig;

/*
 * 领养宠物
 */
public class 练习2_多态 {
	public static void main(String[] args) {
		showMenu();
	}

	/*
	 * 显示主菜单
	 */
	public static void showMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("================欢迎来到宠物店=================");
		System.out.print("请选择您要领养的宠物（1.狗狗  2.猫咪 3.猪猪）：");
		int choice = input.nextInt();
		Pet pet = getPet(choice);
		pet.show();
		pet.play();
	}

	/*
	 * 根据选择返回相应的宠物
	 */
	public static Pet getPet(int choice) {
		Pet pet = null;
		switch (choice) {
			case 1:
				pet = new Dog("旺财", "公", "游戏");
				break;
			case 2:
				pet = new Cat("猫咪", "母", "波斯猫");
				break;
			case 3:
				pet = new Pig("佩琪", "母");
				break;
			default:
				System.out.println("输入有误，没有对应的宠物！");
		}
		return pet;
	}

}
