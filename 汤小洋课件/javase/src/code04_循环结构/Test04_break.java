package code04_循环结构;

public class Test04_break {
	public static void main(String[] args) {
		/*
		 * 将1-10之间的整数相加，当累加值大于20时停止相加，输出当前整数和累加值
		 */
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
			if (sum > 20) {
				System.out.println("当前整数：" + i);
				break; //中止循环的执行
			}
		}
		System.out.println("累加值：" + sum);
	}
}
