package code08_三大特征;

/*
 * 定义一个Programmer程序员类，包含如下的属性和方法
 *    属性：姓名、年龄、技术方向
 *    方法：自我介绍、工作
 *    
 * 要求：
 * 	  1.对属性进行封装，并提供getter/setter方法
 *    2.限制年龄必须大于18岁，否则提示年龄无效，并设置为默认年龄18
 *    3.技术方向为只读的，通过构造方法初始化   
 */
public class 练习1_封装 {
	public static void main(String[] args) {
		Programmer p = new Programmer("唐伯虎", 25, "Java");
		
		p.introduce();
		p.work();
	}
}

class Programmer {
	private String name;
	private int age;
	private String skill;

	public Programmer() {
	}

	public Programmer(String name, int age, String skill) {
		this.name = name;
		this.age = age;
		this.skill = skill;
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
		if (age < 18) {
			System.out.println("年龄无效，已设置为默认年龄18");
		} else {
			this.age = age;
		}
	}

	public String getSkill() {
		return skill;
	}

	// 自我介绍
	public void introduce() {
		System.out.println("我叫：" + name + "，年龄：" + age + "，技术方向：" + skill);
	}
	
	//工作
	public void work(){
		System.out.println("正在使用"+skill+"开发项目。。。。");
	}

}