package code02_运算符;

import java.util.Scanner;

/*
 * 从控制台获取Java、Oracle、HTML三门课程的成绩，计算总分和平均分
 */
public class 练习1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入Java成绩：");
		int java = input.nextInt();
		System.out.print("请输入Oracle成绩：");
		int oracle = input.nextInt();
		System.out.print("请输入HTML成绩：");
		int html = input.nextInt();

		double sum = java + oracle + html; // 总分
		// double avg = sum / 3; // 两个整数进行除法运算时结果仍为整数
		double avg = sum / 3; // 将被除数或除数改为小数即可

		System.out.println("---------------------------------");
		System.out.println("Java\t\tOracle\t\tHTML");
		System.out.println(java + "\t\t" + oracle + "\t\t" + html);
		System.out.println("---------------------------------");
		System.out.println("总分：" + sum);
		System.out.println("平均分：" + avg);

	}
}
