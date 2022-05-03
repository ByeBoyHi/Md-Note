package code16_线程.test06_线程安全问题;

public class Ticket implements Runnable {

	private static int num = 100; // 共计100张票，共享此数据
	//Object obj=new Object();

	@Override
	public void run() {
		// 只需要将关键代码放到synchronized块中，不要将run()方法中所有代码都添加进去，否则相当于单线程
		
		System.out.println(Thread.currentThread().getName() + "正在售票！");

		while (true) {
			// 同步代码块，保护共享数据的安全
//			synchronized (this) { //多个线程必须使用同一把锁
//				if (num > 0) {
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName()
//							+ "----售出车票：" + num--);
//				}
//			}
			sellTicket();
			
		}
	}
	
	// 同步方法，使用的是this锁
//	public synchronized void sellTicket(){
//		if (num > 0) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println(Thread.currentThread().getName()
//					+ "----售出车票：" + num--);
//		}
//	}
	
	// 静态方法，使用的是当前类的Class对象的锁  
	public static synchronized void sellTicket(){
		if (num > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+ "----售出车票：" + num--);
		}
	}
}
