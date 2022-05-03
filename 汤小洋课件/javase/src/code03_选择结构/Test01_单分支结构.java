package code03_选择结构;

import java.util.Scanner;

public class Test01_单分支结构 {
	public static void main(String[] args) {
		int age = 19;
		if (age >= 18) {
			System.out.println("恭喜您");
			System.out.println("您成年了");
		}
		System.out.println("if之后的代码");
		
		/*
		 * 如果if条件成立时要执行的代码只有一行，此时可以省略大括号（不推荐）
		 */
		if(true)
			System.out.println("嘿嘿");
		
		/*
		 * 获取Java和Python课程的成绩
		 * 如果两门都大于95，或Java等于100且Python大于90，或Python等于 100且Java大于90，则奖励iPhone X
		 */
		Scanner input = new Scanner(System.in);
		System.out.print("请输入Java成绩：");
		int java = input.nextInt();
		System.out.print("请输入Python成绩：");
		int python = input.nextInt();
		if((java>95&&python>95)||(java==100&&python>90)||(python==100&&java>90)){
			System.out.println("奖励iPhone X");
		}
		
	}
}
