package code04_循环结构;

public class Test05_continue {
	public static void main(String[] args) {
		/*
		 * 输出1到30之间所有的奇数
		 */
		for (int i = 1; i <= 30; i++) {
			if (i % 2 == 0) {
				continue; // 本次循环不再执行，直接执行一次循环
			}
			System.out.println(i);
		}
	}
}
