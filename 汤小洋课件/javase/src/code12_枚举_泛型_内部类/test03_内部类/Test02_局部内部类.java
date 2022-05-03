package code12_枚举_泛型_内部类.test03_内部类;

public class Test02_局部内部类 {
	public static void main(String[] args) {
		MOuter out = new MOuter();
		out.show();
	}
}

class MOuter { // 外部类
	int age=20;

	public void show() {
		String sex="male";

		class MInner { // 局部内部类
			String name="tom";
			
			public void write(){
				System.out.println("MOuter.show().MInner.write()");
				System.out.println(name);
				System.out.println(age);
				System.out.println(sex); // 在jdk8之前，不能访问非final修饰的变量，在jdk8中可以，这是一种语法糖
				// sex = "female"; // 报错
			}
		}
		
		// 只能在外部类的方法中创建局部内部类的对象
		MInner in = new MInner();
		System.out.println(in.name);
		in.write();
	}

}
