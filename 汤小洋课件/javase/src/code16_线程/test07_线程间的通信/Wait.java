package code16_线程.test07_线程间的通信;

public class Wait extends Thread {
	
	private Object obj;
	
	public Wait(Object obj){
		this.obj=obj;
	}
	
	@Override
	public void run() {
		System.out.println(111);

		synchronized (obj) {
			try {
				System.out.println(getName() + "释放锁，即将进入等待池。。。。");
				// this.wait(2000); //等待的超时时间
				obj.wait();
			} catch (InterruptedException e) {
				System.out.println(getName()+"被中断。。。。");
			}
		}

		System.out.println(222);
	}
}
