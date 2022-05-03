package code16_线程;

/*
 * 现象：输出结果可能未按照顺序显示
 * 原因：虽然执行了出票的操作，但可能暂时未显示打印结果，而此时另一个线程先打印出来了
 */
public class Test03_两种方式的对比 {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("窗口1");
		MyThread2 t2 = new MyThread2("窗口2");
		t1.start();
		t2.start();
		
//		MyTicket ticket = new MyTicket();
//		Thread t1 = new Thread(ticket, "窗口1");
//		Thread t2 = new Thread(ticket, "窗口2");
//		t1.start();
//		t2.start();
	}
}

class MyThread2 extends Thread {
	int num = 100; // 100张票

	public MyThread2(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (num > 0) {
			System.out.println(getName() + "------" + num--);
		}
	}
}

class MyTicket implements Runnable{
	int num = 100; // 100张票
	
	@Override
	public void run() {
		while (num > 0) {
			System.out.println(Thread.currentThread().getName() + "------" + num--);
		}
	}
	
}
