package code12_枚举_泛型_内部类.test03_内部类;

import code12_枚举_泛型_内部类.test03_内部类.Outer.Inner;

public class Test01_成员内部类 {
	public static void main(String[] args) {
		Outer out = new Outer();
		out.show();
		
		/*
		 *  2.在外部类外访问内部类
		 *  在外部类的外面创建内部类的对象，语法：外部类.内部类  对象名=外部类对象.new 内部类();
		 */
//		Outer out = new Outer(); //必须先创建外部类的对象
//		Inner in = out.new Inner(); //根据外部类的对象再创建内部类的对象
//		System.out.println(in.age);
//		in.print();
	}
}

class Outer { // 外部类
	private String name = "tom";
	private int age=18;
	static String address="南京";

	public void show() {
		System.out.println("Outer.show()");
		
		// 1.在外部类中访问内部类
		Inner in = new Inner();
		System.out.println(in.age);
		System.out.println(in.sex);
		in.print();
	}

	class Inner { // 内部类
		int age=20;
		private String sex="male";
		
		public void print(){
			System.out.println("Outer.Inner.print()");
			
			// 3.在内部类中访问外部类
			System.out.println(name);
			System.out.println(this.age);
			System.out.println(Outer.this.age);
			System.out.println(Outer.address);
		}
	}
}
