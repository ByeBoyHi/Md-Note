package code14_异常;

public class Test02_异常处理 {
	public static void main(String[] args) {
		int[] nums = { 12, 4, 2 };

		try {
			System.out.println("可能会出现异常的代码");

			System.out.println(nums[1]);
			
			// return;  // finally依然会执行
			// System.exit(0); // 终止当前正在运行的JVM，finally不会再执行
		} catch (ArrayIndexOutOfBoundsException e) { // 指定要捕获的异常类型，并获取异常对象
			System.out.println("出现异常后要执行的代码");
			
			// 异常对象中包含了异常的详细信息
			// e.printStackTrace(); //打印堆栈中的异常详细信息，通过单独线程进行打印的，使用System.err.println();
			System.out.println(e.getMessage()); //获取异常的消息字符串
		} finally {
			System.out.println("无论是否出现异常都必须要执行的代码");
		}
		
		System.out.println("异常后面的代码。。。。。");
	}
}
