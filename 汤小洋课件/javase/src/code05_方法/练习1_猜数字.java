package code05_方法;

import java.util.Scanner;

/*
 * 随机生成[0,100]之间的随机数，让用户猜生成的数字，显示猜大了、猜小了，如果猜对了，提示共猜了多少次。
 */
public class 练习1_猜数字 {
	public static void main(String[] args) {
		int x = (int) (Math.random() * 101);
		System.out.println(x);
		Scanner input = new Scanner(System.in);
		
		int count = 0;
		while (true) {
			count++;
			System.out.print("请输入您要猜的数字：");
			int guess = input.nextInt();
			if (guess > x) {
				System.out.println("猜大了");
			}
			if (guess < x) {
				System.out.println("猜小了");
			}
			if (guess == x) {
				System.out.println("恭喜您，猜对了，共猜了：" + count + "次");
				break;
			}
		}
	}
}
