package code11_常用类.test04_包装类;

public class Test01_包装类 {
	public static void main(String[] args) {
		int num = 10; // 创建一个int类型的变量，值为10
		Integer integer = new Integer(10); // 创建一个Integer包装类的对象，值为10
		Character c = new Character('a');
		Double d = new Double(12.5);

		/*
		 * 包装类具有面向对象的特性，可以调用方法
		 */
		int a = integer.intValue();
		double b = integer.doubleValue();
		
		/*
		 * 包装类作为参数传递时，属于值传递，而非引用传递
		 */
		
		m(integer);
		System.out.println(integer);
	}
	
	public static void m(Integer integer){
		integer=666;
	}
	
}
