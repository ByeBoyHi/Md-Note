package code12_枚举_泛型_内部类.test03_内部类;

import code12_枚举_泛型_内部类.test03_内部类.SOuter.SInner;

public class Test03_静态内部类 {
	public static void main(String[] args) {
		// 创建静态内部类对象时，无需创建外部类的对象
		SInner in = new SInner();
		in.show();
	}
}

class SOuter{

	int age=20;
	static String sex="male";
	
	static class SInner{ //静态内部类
		
		String name="tom";
		
		public void show(){
			System.out.println(name);
			System.out.println(sex);
		}
		
	}
}

