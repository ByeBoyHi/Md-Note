package code12_枚举_泛型_内部类.test01_枚举;

/*
 * 自定义一个枚举类型
 */
public enum Season {

	// 定义枚举类型对象，即枚举项
	SPRING("春天", 1, 3), SUMMER("夏天", 4, 6), AUTUMN("秋天", 7, 9), WINTER("冬天",
			10, 12), ALL;

	// SPRING, SUMMER, AUTUMN, WINTER, ALL;

	private String name; // 季节名称
	private int startMonth; // 起始月份
	private int endMonth; // 结束月份

	private Season() {
	}

	private Season(String name, int startMonth, int endMonth) {
		this.name = name;
		this.startMonth = startMonth;
		this.endMonth = endMonth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}

}
