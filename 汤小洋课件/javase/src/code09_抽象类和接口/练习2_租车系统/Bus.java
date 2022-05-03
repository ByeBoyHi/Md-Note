package code09_抽象类和接口.练习2_租车系统;

/*
 * 客车类
 */
public class Bus extends MotoVehicle {
	private int seatCount;

	public Bus() {
		super();
	}

	public Bus(String no, String brand, int seatCount) {
		super(no, brand);
		this.seatCount = seatCount;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public int calcRent(int day) {
		int sum = 0;
		if (seatCount <= 16) {
			sum = 800 * day;
		} else {
			sum = 1200 * day;
		}
		return sum;
	}

}
