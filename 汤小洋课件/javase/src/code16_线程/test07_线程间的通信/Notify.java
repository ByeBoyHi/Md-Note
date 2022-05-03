package code16_线程.test07_线程间的通信;

public class Notify extends Thread{
	private Object obj;
	
	public Notify(Object obj){
		this.obj=obj;
	}
	
	@Override
	public void run() {
		
		synchronized (obj) {
			obj.notifyAll();
			System.out.println(getName()+"已唤醒等待池中的线程。。。。。");
		}
		
	}
}
