package code08_三大特征;

public class Test07_多态 {
	public static void main(String[] args) {
		/*
		 * 自动类型转换
		 */
		Person person = new Teacher(); // 向上转型
		person.name = "tom";
		person.show(); // 调用的是子类重写后的方法
		// person.school="南京大学"; //无法访问子类特有的属性和方法
		// person.teach();

		/*
		 * 强制类型转换
		 */
		// Teacher t=(Teacher)person; //向下转型
		// t.school="南京大学"; //可以访问子类特有的属性和方法
		// t.teach();
		
		if(person instanceof Doctor){ //判断一个对象是否属于某个类或者实现某个接口，结果为true或false
			Doctor d = (Doctor) person;
			d.hospital="江苏省人民医院";
			d.operate();
		}

	}
}

class Person {
	String name;

	public void show() {
		System.out.println("我是一个人");
	}
}

class Teacher extends Person {
	String school; // 所在学校

	// 重写父类的方法
	public void show() {
		System.out.println("我叫" + name + "，我是一个老师");
	}

	// 子类特有的方法
	public void teach() {
		System.out.println("我正在" + school + "进行教学。。。。。。");
	}
}

class Doctor extends Person {
	String hospital; // 所在医院

	// 重写父类的方法
	public void show() {
		System.out.println("我叫" + name + "，我是一个医生");
	}

	// 子类特有的方法
	public void operate() {
		System.out.println("我正在" + hospital + "做手术。。。。。。");
	}
}
