package code18_设计模式.test03_工厂模式.demo01;

/*
 * 工厂类
 */
public class MotoVehicleFactory {

	public MotoVehicle create(String type) {
		if ("car".equals(type)) {
			return new Car();
		} else if ("bus".equals(type)) {
			return new Bus();
		} else if ("truck".equals(type)) {
			return new Truck();
		}
		return null;
	}

}
