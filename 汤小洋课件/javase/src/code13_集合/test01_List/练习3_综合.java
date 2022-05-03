package code13_集合.test01_List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * 定义一个学生类Stu
 * 属性：id、name、age
 * 
 * 1.提示用户循环输入学生的信息，存储到ArrayList集合中
 * 2.输出所有学生的信息
 * 3.根据学号修改指定学生信息
 * 4.根据学号删除学生
 */
public class 练习3_综合 {

	static Scanner input = new Scanner(System.in);
	static List<Stu> list = new ArrayList<Stu>();

	public static void main(String[] args) {
		inputStudentInfo();

		printStudentInfo();
		
		System.out.print("请输入要修改的学生学号：");
		int id = input.nextInt();
		modifyById(id);
		
		System.out.print("请输入要删除的学生学号：");
		removeById(input.nextInt());
	}

	// 输入学生信息
	public static void inputStudentInfo() {
		while (true) {
			System.out.println("-----请输入学生信息------");
			Stu stu = new Stu();
			System.out.print("请输入学号：");
			int id = input.nextInt();
			if (id == 0) {
				break;
			}
			stu.setId(id);
			System.out.print("请输入姓名：");
			stu.setName(input.next());
			System.out.print("请输入年龄：");
			stu.setAge(input.nextInt());

			list.add(stu);
		}
	}

	// 输出学生信息
	public static void printStudentInfo() {
		System.out.println("===============学生信息如下=================");
		System.out.println("学号\t姓名\t年龄");
		for (Stu stu : list) {
			System.out.println(stu.getId() + "\t" + stu.getName() + "\t"
					+ stu.getAge());
		}
	}

	// 根据学号修改学生信息
	public static void modifyById(int id) {
		// 查找判断学生是否存在
		Stu stu = findById(id);
		if (stu == null) {
			System.out.println("指定学号的学生不存在！");
			return;
		}
		// 修改学生信息
		System.out.print("请输入要修改的姓名：");
		String name = input.next();
		stu.setName(name);
		System.out.print("请输入要修改的年龄：");
		int age = input.nextInt();
		stu.setAge(age);
		System.out.println("修改成功！");
		printStudentInfo(); // 显示修改后的学生信息
	}

	// 根据学号查找学生
	public static Stu findById(int id) {
		Iterator<Stu> it = list.iterator();
		while (it.hasNext()) {
			Stu stu = it.next();
			if (stu.getId() == id) {
				return stu;
			}
		}
		return null;
	}

	// 根据学号删除学生
	public static void removeById(int id){
		Stu stu = findById(id);
		if (stu == null) {
			System.out.println("指定学号的学生不存在！");
			return;
		}
		list.remove(stu);
		System.out.println("删除成功！");
		printStudentInfo(); //显示删除后的学生信息
	}
}

class Stu {
	private int id;
	private String name;
	private int age;

	public Stu() {
		super();
	}

	public Stu(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
