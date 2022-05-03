package code11_常用类.test04_包装类;

public class Test02_基本类型和包装类的转换 {
	public static void main(String[] args) {
		/*
		 * 装箱和拆箱
		 */
		int a = 10;
		// 装箱
		Integer integer = new Integer(a); // 手动
		Integer integer2 = a; // 自动
		// 拆箱
		int b = integer.intValue(); // 手动
		int c = integer; // 自动

		/*
		 * 基本数据类型和包装类进行运算，会自动进行拆箱
		 */
		int m = 6;
		Integer n = new Integer(8);
		int p = m + n; //自动拆箱
		
		int x=3;
		Integer y = new Integer(3);
		Integer z = new Integer(3);
		System.out.println(y==z);
		System.out.println(x==z); // 因为z在进行运算时发生了自动拆箱
		
		/*
		 * 下面代码是否正确，为什么？  
		 * 先自动装箱，然后多态
		 */
		Object obj=5;
	}
}
