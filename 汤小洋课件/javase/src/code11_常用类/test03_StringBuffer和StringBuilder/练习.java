package code11_常用类.test03_StringBuffer和StringBuilder;

/*
 * 删除所有下标是3的倍数的字符
 */
public class 练习 {
	public static void main(String[] args) {
		String str = "sadjf;o3ei2jk;jsdf";

		StringBuffer buffer = new StringBuffer(str);

		// 要从后往前删除，不能从前往后，原因是每删除一个字符，该位后面的字符就会往前移动
		for (int i = buffer.length() - 1; i >= 0; i--) {
			if (i % 3 == 0) {
				buffer.deleteCharAt(i);
			}
		}
		System.out.println(buffer);
	}
}
