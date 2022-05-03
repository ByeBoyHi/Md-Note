package code06_数组;

import java.util.Scanner;

/*
 * 有三个班，每个班有5名学生，提示用户分别输入学生的成绩，将数据保存到二维数组中
 * 计算每个班的平均分、全校的最高分、最低分
 */
public class 练习2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[][] scores = new int[3][5];
		for (int i = 0; i < scores.length; i++) {
			System.out.println("-------请输入第" + (i + 1) + "个班级的学生成绩-------");
			double sum = 0, avg = 0;
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print("请输入第" + (j + 1) + "名学生的成绩：");
				scores[i][j] = input.nextInt();
				sum += scores[i][j];
			}
			avg = sum / 5;
			System.out.println("第" + (i + 1) + "个班级的平均分为：" + avg);
		}

		// 获取最高分、最低分
		int max = scores[0][0], min = scores[0][0];
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				if (scores[i][j] > max) {
					max = scores[i][j];
				}
				if (scores[i][j] < min) {
					min = scores[i][j];
				}
			}
		}
		System.out.println("最高分：" + max);
		System.out.println("最低分：" + min);
	}
}
