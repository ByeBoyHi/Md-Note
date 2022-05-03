package code04_循环结构;

/*
 * 实现输出九九乘法表
 */
public class 练习4_二重循环 {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + i * j+" ");
			}
			System.out.println();
		}
	}
}
