package code19_JDBC.练习2_改写.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * 学生类
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -5984449679344766226L;

	private Integer id;
	private String name;
	private Integer age;
	private Double height;
	private Date bithday;
	private Clazz clazz; // 所在班级

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Date getBithday() {
		return bithday;
	}

	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", height=" + height + ", bithday=" + bithday + ", clazz="
				+ clazz + "]\n";
	}

	
}
