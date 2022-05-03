package code09_抽象类和接口;

public class Test05_接口的作用 {
	public static void main(String[] args) {
		Computer computer = new Computer();
		
		//将接口的引用，指向实现类的实例，实现多态
		Usb usb = new Mouse(); //向上转型
		
		computer.runDevice(new Keyboard());
	}
}

class Computer{
	
	public void runDevice(Usb usb){ //只要是符合USB接口的设备都可以
		usb.power();
	}
	
	
}

/*
 * Usb接口，是一种标准
 */
interface Usb{
	
	//具有供电的功能，必须实现此方法
	public void power();
	
}

class Mouse implements  Usb{

	@Override
	public void power() {
		System.out.println("这是鼠标，符合USB标准");
	}
	
}

class Keyboard implements Usb{

	@Override
	public void power() {
		System.out.println("这是键盘，符合USB标准");
	}
	
}


