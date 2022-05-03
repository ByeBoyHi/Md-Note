package code12_枚举_泛型_内部类.test02_泛型;

public class Test02_泛型接口 {
	public static void main(String[] args) {
		Person p1 = new Person("tom", 16, 5000);
		Person p2 = new Person("jack", 18, 4000);
		System.out.println(p1.isBetter(p2));
	}
}

/*
 * 泛型接口
 */
interface CompareInterface<T> {
	public boolean isBetter(T t);
}

class Person implements CompareInterface<Person> { // 指定T为Person类型
	private String name;
	private int age;
	private int salary;

	public Person() {
		super();
	}

	public Person(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public boolean isBetter(Person t) { // t为Person类型
		if (this.age < t.getAge() && this.salary > t.getSalary()) {
			return true;
		}
		return false;
	}

}