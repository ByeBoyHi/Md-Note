package code13_集合.test01_List;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 提示用户输入5名学生的学号和成绩，创建Student对象，然后放到ArrayList集合中
 * 1.遍历集合，删除学号为2的学生（删除成绩小于60的所有学生）
 * 2.不遍历集合，删除学号为3的学生
 * 3.不遍历集合，判断集合中是否包含学号为3的学生
 */
public class 练习2_ArrayList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Student> list = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			System.out.println("-------请输入第" + i + "个学生的信息-------");
			Student stu = new Student();
			System.out.print("请输入学号：");
			stu.setNo(input.nextInt());
			System.out.print("请输入成绩：");
			stu.setScore(input.nextInt());
			
			list.add(stu); // 向集合中添加Student对象
		}
		
		// 1.遍历集合，删除学号为2的学生
		for(int i=0;i<list.size();i++){
			Student s = list.get(i); // 集合中的每个元素都是一个Student对象
			if(s.getNo()==2){
				list.remove(i);
			}
		}
		
		// 2.不遍历集合，删除学号为3的学生
		Student student = new Student();
		student.setNo(3);
		list.remove(student);
		
		// 3.不遍历集合，判断集合中是否包含学号为3的学生
		System.out.println(list.contains(student));
		
		System.out.println(list);
		
	}
}

class Student {
	private int no;
	private int score;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	// 重写equals()方法，根据学号no判断是否相等
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (no != other.no)
			return false;
		return true;
	}
	
	
	
	

}