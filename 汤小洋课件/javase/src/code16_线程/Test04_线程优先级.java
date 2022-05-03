package code16_线程;

/*
 * 线程优先级
 * 范围[1,10]
 * 优先级越高，执行机会越大，只是概率，并不一定
 */
public class Test04_线程优先级 {
	public static void main(String[] args) {
		// System.out.println("最大优先级："+Thread.MAX_PRIORITY);
		// System.out.println("最小优先级："+Thread.MIN_PRIORITY);
		// System.out.println("普通优先级："+Thread.NORM_PRIORITY);
		// System.out.println(Thread.currentThread().getPriority());

		for (int i = 1; i <= 20; i++) {
			MyThread3 t1 = new MyThread3();
			MyThread3 t2 = new MyThread3();
			t1.setPriority(10);
			t2.setPriority(1);
			t1.start();
			t2.start();
		}

	}
}

class MyThread3 extends Thread {

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		String str = "";
		for (int i = 1; i <= 10000; i++) {
			str += i;
		}
		long end = System.currentTimeMillis();
		System.out
				.println(getPriority() + "-----------" + (end - start) + "ms");
	}
}
