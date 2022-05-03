package code04_循环结构;

import java.util.Scanner;

/*
 * 1.某次技能大赛，共有3个班参加，每个班有4名学生参加，计算每个班级的平均分
 * 2.只统计成绩大于80分的学生的平均分
 */
public class Test06_二重循环 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 外层循环控制班级数量
		for (int i = 1; i <= 3; i++) {
			double sum = 0;
			int count = 0; // 统计符合条件的学生数量
			// 内层循环控制每个班级的学生数量
			for (int j = 1; j <= 4; j++) {
				System.out.print("请输入第" + i + "个班级第" + j + "名学生的成绩:");
				int score = input.nextInt();

				// 在二重循环中使用continue针对的是内层循环
				if (score < 80) {
					continue;
				}
				count++;
				sum += score;
			}
			double avg = sum / count;
			System.out.println("第" + i + "个班级的平均分为：" + avg);
		}
	}
}
