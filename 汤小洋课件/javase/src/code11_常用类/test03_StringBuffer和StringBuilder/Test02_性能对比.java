package code11_常用类.test03_StringBuffer和StringBuilder;

public class Test02_性能对比 {
	public static void main(String[] args) {
		// String str = "";
		StringBuffer sb = new StringBuffer();

		long start = System.currentTimeMillis(); // 获取当前时间的毫秒值
		for (int i = 1; i <= 100000; i++) {
			// str += "hello";
			sb.append("hello");
		}
		long end = System.currentTimeMillis();

		System.out.println("花费的时间：" + (end - start) + "ms");
	}
}
