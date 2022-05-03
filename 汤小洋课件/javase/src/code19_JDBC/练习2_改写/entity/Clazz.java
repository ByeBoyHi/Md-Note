package code19_JDBC.练习2_改写.entity;

import java.io.Serializable;

/*
 * 班级类
 */
public class Clazz implements Serializable {

	private static final long serialVersionUID = 4262995174037152678L;

	private Integer id;
	private String name;

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

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + "]\n";
	}

	
}
