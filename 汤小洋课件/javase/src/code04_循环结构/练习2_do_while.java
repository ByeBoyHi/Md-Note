package code04_循环结构;

/*
 * 打印输出[0,200]之间所有能被7整除，但不能被4整除的所有整数，要求每行打印5个，并统计个数
 */
public class 练习2_do_while {
	public static void main(String[] args) {
		int i = 0;
		int count = 0; // 个数
		do {
			if (i % 7 == 0 && i % 4 != 0) {
				count++; // 统计个数
				System.out.print(i + "\t");
				if (count % 5 == 0) {
					System.out.println();
				}
			}
			i++;
		} while (i <= 200);
		System.out.println("\n总个数：" + count);
	}
}
