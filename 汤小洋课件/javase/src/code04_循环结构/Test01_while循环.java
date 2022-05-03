package code04_循环结构;

public class Test01_while循环 {
	public static void main(String[] args) {
		/*
		 * 输出5次HelloWorld
		 */
		int i = 1;
		while (i <= 5) {
			System.out.println("HelloWorld");
			// i = i + 1;
			// i += 1;
			i++; // 每执行一次累加1
		}

		/*
		 * 计算100以内所有偶数之和
		 */
		int num = 1; // 起始值
		int sum = 0; // 总和
		while (num <= 100) {
			if (num % 2 == 0) {
				sum = sum + num; // 累加求和
			}
			num++;
		}
		System.out.println("总和：" + sum);

	}
}
