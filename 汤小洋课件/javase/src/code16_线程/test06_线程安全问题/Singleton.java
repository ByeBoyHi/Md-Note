package code16_线程.test06_线程安全问题;

public class Singleton {
	private static Singleton instance;
	
	private Singleton(){
		System.out.println("Singleton.Singleton()");
	}
	
	public synchronized static Singleton getInstance(){
		if(instance==null){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance=new Singleton();
		}
		return instance;
	}
	
}
