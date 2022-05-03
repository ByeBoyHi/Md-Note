package code09_抽象类和接口.练习2_租车系统;

/*
 * 轿车类
 */
public class Car extends MotoVehicle {
	private String type; // 轿车类型

	public Car() {
		super();
	}

	public Car(String no, String brand, String type) {
		super(no, brand);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int calcRent(int day) {
		int sum = 0;
		if (type.equals(CarConstant.AUDI_Q3)) {
			sum = 500 * day;
		} else if (type.equals(CarConstant.AUDI_Q7)) {
			sum = 600 * day;
		} else if (type.equals(CarConstant.BMW_X3)) {
			sum = 400 * day;
		} else if (type.equals(CarConstant.ALTO_A1)) {
			sum = 200 * day;
		}
		return sum;
	}

}
