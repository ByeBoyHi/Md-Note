package code16_线程;

public class Test02_实现Runnable接口 {
	public static void main(String[] args) {

		// 创建实现类的一个实例
		MyRunnable mr = new MyRunnable();
		// 创建线程
		Thread t1 = new Thread(mr); // 将Runnable接口的对象传入
		// 启动线程
		t1.start();

		Thread t2 = new Thread(mr);
		t2.start();

		for (int i = 1; i <= 10000; i++) {
			System.out.println(Thread.currentThread().getName()
					+ "------------" + i);
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10000; i++) {
			System.out.println(Thread.currentThread().getName()
					+ "------------" + i);
		}
	}

}
