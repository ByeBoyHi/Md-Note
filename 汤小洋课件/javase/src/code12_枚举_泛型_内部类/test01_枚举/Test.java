package code12_枚举_泛型_内部类.test01_枚举;

public class Test {
	public static void main(String[] args) {
		Sport s = new Sport();
		s.setName("滑雪");
		s.setSeason(Season.WINTER);
		
		System.out.println(s.getSeason().getName());
		System.out.println(s.getSeason().getStartMonth());
		System.out.println(s.getSeason().getEndMonth());
		
		/*
		 * 获取所有枚举项
		 */
		Season[] values = Season.values();
		for (Season v : values) {
			System.out.println(v);
		}
	}
}
