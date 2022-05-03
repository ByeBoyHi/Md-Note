package code11_常用类.test02_String;

public class Test06_不变性 {
	public static void main(String[] args) {
		/*
		 * 基本数据类型
		 */
		int i = 3;
		i = 6; // 内存中只有一个变量值6，3的值会被6覆盖

		/*
		 * 字符串（特殊的引用类型）
		 */
		String str = "tom";
		str = "jack"; // 当重新赋值时会在内存中再分配一块空间，创建一个新的String，所以内存中有两个String对象，分别是tom和jack
	}
}
