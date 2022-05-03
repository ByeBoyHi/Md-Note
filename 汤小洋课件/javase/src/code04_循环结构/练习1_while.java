package code04_循环结构;

import java.util.Scanner;

/*
 * 循环提示用户输入一个非零整数，直接输入数字0为止，然后输出其中的最大值和最小值
 */
public class 练习1_while {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入非零整数（0表示结束）：");
		int n = input.nextInt();
		int max = n, min = n;

		while (n != 0) {
			System.out.print("请输入非零整数（0表示结束）：");
			n = input.nextInt();
			if(n!=0){
				if (n > max) {
					max = n;
				}
				if (n < min) {
					min = n;
				}
			}
		}
		
		System.out.println("最大值："+max);
		System.out.println("最小值："+min);
	}
}
