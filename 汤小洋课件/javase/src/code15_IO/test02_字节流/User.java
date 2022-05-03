package code15_IO.test02_字节流;

import java.io.Serializable;

/*
 * 实现Serializable接口
 */
public class User implements Serializable {

	// 根据类名、接口名、成员方法和属性等生成的一个64位的哈希值
	private static final long serialVersionUID = 705661196096434175L;
	private Integer id; // 都使用包装类型，默认为null
	private String name;
	private transient Integer age;  // transient修饰的属性不会被序列化（static变量也不会被序列化）
	private Address address; // 对象属性也必须实现Serializable接口

	public User() {
		super();
	}

	public User(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}

	

}
