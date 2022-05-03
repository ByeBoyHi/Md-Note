package code03_选择结构;

import java.util.Scanner;

/*
 * 提示用户输入三角形的边a、b、c，范围必须在[1,100)之间
 * 判断三角形的类型：
 * 1.非三角形
 * 2.等边三角形
 * 3.直角三角形
 * 4.等腰三角形
 * 5.普通三角形
 */
public class 练习2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入第一个边：");
		int a = input.nextInt();
		System.out.print("请输入第二个边：");
		int b = input.nextInt();
		System.out.print("请输入第三个边：");
		int c = input.nextInt();

		if (a < 1 || a >= 100 || b < 1 || b >= 100 || c < 1 || c >= 100) {
			System.out.println("数据无效！");
		} else {
			if (a + b < c || a + c < b || b + c < a) {
				System.out.println("非三角形！");
			} else {
				if (a == b && a == c) {
					System.out.println("等边三角形！");
				} else if (a * a + b * b == c * c || a * a + c * c == b * b
						|| b * b + c * c == a * a) {
					System.out.println("直角三角形！");
				}else if(a==b || a==c || b==c){
					System.out.println("等腰三角形！");
				}else{
					System.out.println("普通三角形！");
				}
			}
		}

	}
}
