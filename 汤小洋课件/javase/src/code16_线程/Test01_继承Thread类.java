package code16_线程;

/*
 * JVM启动时会创建一个主线程，用来执行main方法
 * 要想实现多线程，需要在主线程中创建新的线程
 * 
 * 实际上，Java程序在运行时至少会启动两个线程：main线程、垃圾回收线程gc
 */
public class Test01_继承Thread类 {
	public static void main(String[] args) {

		// 创建线程
		MyThread t1 = new MyThread(); //自定义线程的默认名称：Thread-编号，编号从0开始
		t1.setName("线程1");
		// 启动线程，并调用run()方法
		t1.start(); // 线程并不一定立即执行，要获取到CPU时间片才会执行
		
		MyThread t2 = new MyThread("线程2");
		t2.start();

		Thread t = Thread.currentThread(); // 获取当前的线程对象
		t.setName("主线程");
		for (int i = 1; i <= 10000; i++) {
			System.out.println(t.getName()+"------------" + i); //主线程的默认名称就是main
		}
	}
}

class MyThread extends Thread {
	
	public MyThread(){
		
	}
	
	public MyThread(String name){
		super(name); //调用父类的构造方法，指定线程名
	}

	// 在run()方法中编写线程要执行的代码
	@Override
	public void run() {
		for (int i = 1; i <= 10000; i++) {
			System.out.println(getName()+"------------" + i); // 调用getName()获取线程名
		}
	}

}
