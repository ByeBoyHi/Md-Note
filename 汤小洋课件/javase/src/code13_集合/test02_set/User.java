package code13_集合.test02_set;

/*
 * 实现Comparable接口，让对象具有可比较性
 */
public class User implements Comparable<User>{
//public class User{
	private String name; // 姓名
	private int age; // 年龄
	private int score; // 成绩

	public User() {
		super();
	}

	public User(String name, int age, int score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/*
	 * 重写compareTo()方法，指定比较的方式
	 * 升序：如果该对象大于、小于或等于指定对象，则分别返回正整数、负整数或零
	 * 降序：如果该对象大于、小于或等于指定对象，则分别返回负整数、正整数或零
	 */
	@Override
	public int compareTo(User o) {
		// 根据年龄比较，升序
		if(this.age>o.getAge()){
			return 1;
		}else if(this.age<o.getAge()){
			return -1;
		}else{
			//如果年龄相同，则按分数比较，降序
			if(this.score>o.getScore()){
				return -1;
			}else if(this.score<o.getScore()){
				return 1;
			}else{
				//如果分数相同，则按姓名比较
				return this.name.compareTo(o.getName()); //调用String中的compareTo()方法
			}
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", score=" + score + "]\n";
	}
	
	

}
