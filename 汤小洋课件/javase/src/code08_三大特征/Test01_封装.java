package code08_三大特征;

public class Test01_封装 {
	public static void main(String[] args) {
		User user = new User();
		// user.id = 1001;
		// user.name = "唐伯虎";
		// user.age = -190;
		// user.sex = "妖";

		user.setAge(29);

		user.show();

		System.out.println(user.getAge());
	}
}

class User {
	private int id;
	private String name;
	private int age;
	private String sex;
	private boolean married;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	// 赋值
	public void setAge(int age) {
		if (age >= 1 && age <= 100) {
			this.age = age;
		} else {
			System.out.println("age无效，已设置为默认值18");
			this.age = 18;
		}
	}

	// 取值
	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		if (sex.equals("男") || sex.equals("女")) {
			this.sex = sex;
		} else {
			this.sex = "男";
		}
	}

	public void show() {
		System.out.println("编号：" + id + "，姓名：" + name + "，年龄：" + age + "，性别："
				+ sex);
	}
}
