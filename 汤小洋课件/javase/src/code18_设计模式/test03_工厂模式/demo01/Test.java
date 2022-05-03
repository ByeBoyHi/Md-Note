package code18_设计模式.test03_工厂模式.demo01;

public class Test {
	public static void main(String[] args) {
		MotoVehicleFactory factory = new MotoVehicleFactory();
		MotoVehicle car=factory.create("car");
		car.run();
		
		MotoVehicle bus = factory.create("bus");
		bus.run();
	}
}
