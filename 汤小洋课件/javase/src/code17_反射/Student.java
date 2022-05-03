package code17_反射;

import java.io.Serializable;

public final class Student extends Person implements Cloneable, Serializable {
	public String sex;
	private Double height;

	public Student() {
		System.out.println("Student.Student()");
	}

	public Student(String name, String sex, double height) {
		this.name = name;
		this.sex = sex;
		this.height = height;
		System.out.println("Student.Student()");
	}
	
	private Student(String sex){
		this.sex=sex;
	}

	public void b() {
		System.out.println("Student.b()");
	}

	public int c(int x, int y) {
		return x + y;
	}

	private double c(int x, double y) {
		return x + y;
	}

	@Override
	public String toString() {
		return "Student [sex=" + sex + ", height=" + height + "]";
	}

}
