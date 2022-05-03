package code16_线程.test06_线程安全问题;

public class Test {
	public static void main(String[] args) {
//		Ticket ticket = new Ticket();
//		
//		Thread t1 = new Thread(ticket,"窗口1");
//		Thread t2 = new Thread(ticket,"窗口2");
//		Thread t3 = new Thread(ticket,"窗口3");
//		t1.start();
//		t2.start();
//		t3.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Singleton.getInstance());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Singleton.getInstance());
				
			}
		}).start();
	}
}
