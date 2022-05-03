package code16_线程.test09_线程单例;

public class Test {
	
//	static MyThreadLocal<String> local=new MyThreadLocal<String>();
	static ThreadLocal<String> local=new ThreadLocal<String>();
	
	
	public static void main(String[] args) {
		local.set("aaa");
		local.set("bbb");
		local.set("ccc");
		
		System.out.println(local.get());
		System.out.println(local.get());
		System.out.println(local.get()==local.get());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
//				local.set("aaa");
				System.out.println(local.get());
			}
		}).start();
		
	}
}
