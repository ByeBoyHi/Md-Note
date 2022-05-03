package code03_选择结构;

import java.util.Scanner;

/*
 * 提示用户输入三个整数，判断并输出最大值、最小值
 */
public class 练习1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请依次输入三个整数：");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();

		int max, min;
		// 先比较a和b
		if (a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}

		// 然后将c与max、min进行比较
		if (c > max) {
			max = c;
		}
		if (c < min) {
			min = c;
		}

		System.out.println("最大值：" + max);
		System.out.println("最小值：" + min);

	}
}
