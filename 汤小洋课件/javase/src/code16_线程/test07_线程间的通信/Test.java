package code16_线程.test07_线程间的通信;

public class Test {
	public static void main(String[] args) {
		Object obj = new Object();
		Wait w = new Wait(obj);
		w.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		w.interrupt();
		
		Notify n = new Notify(obj);
		n.start();
	}
}
