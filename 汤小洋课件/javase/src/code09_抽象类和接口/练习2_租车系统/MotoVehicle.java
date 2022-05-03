package code09_抽象类和接口.练习2_租车系统;

/*
 * 机动车类，抽象类
 */
public abstract class MotoVehicle {
	private String no; // 车牌号
	private String brand; // 品牌

	public MotoVehicle() {
		super();
	}

	public MotoVehicle(String no, String brand) {
		super();
		this.no = no;
		this.brand = brand;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	// 计算租金，抽象方法
	public abstract int calcRent(int day);

}
