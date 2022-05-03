package code04_循环结构;

public class Test02_do_while循环 {
	public static void main(String[] args) {
		/*
		 * 输出5次HelloWorld
		 */
		int i = 1;
		do {
			System.out.println("HelloWorld");
			i++;
		} while (i <= 5);

		/*
		 * 计算1到50之间7的倍数的数值之和
		 */
		int num = 1;
		int sum = 0;
		do {
			if (num % 7 == 0) {
				sum += num;
			}
			num++;
		} while (num <= 50);
		System.out.println("总和："+sum);
	}
}
