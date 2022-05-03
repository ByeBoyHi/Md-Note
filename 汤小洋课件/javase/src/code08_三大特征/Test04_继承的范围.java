package code08_三大特征;

public class Test04_继承的范围 {
	public static void main(String[] args) {
		Salesman s = new Salesman();

		System.out.println(s.s1);
		System.out.println(s.s2);
		System.out.println(s.s3);
		// System.out.println(s.s4); //子类不能继承父类中private修饰的成员
	}
}

/*
 * 父类，雇员类
 */
class Employee {
	public String s1;
	protected String s2;
	String s3;
	private String s4;

	public Employee(){
		
	}
}

/*
 * 子类，销售员类
 */
class Salesman extends Employee {

}

/*
 * 子类，经理类
 */
class Manager extends Employee {

}
