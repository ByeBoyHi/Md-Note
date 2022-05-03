package code02_运算符;

import java.util.Scanner;

/*
 * 获取学生tom和jack的考试成绩，比较两个成绩高低，并输出分数差
 * 注：使用条件运算符
 */
public class 练习3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入tom的成绩：");
		int tom = input.nextInt();
		System.out.print("请输入jack的成绩：");
		int jack = input.nextInt();

		String result = (tom - jack > 0 ? "tom比jack高：" + (tom - jack)
				: "jack比tom高:" + (jack - tom)) + "分";

		System.out.println(result);
	}
}
