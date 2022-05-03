package code16_线程;

public class Test05_生命周期 {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= 50; i++) {
					if (i == 8) {
						try {
							Thread.sleep(5000); // 休眠5秒，单位为毫秒
						} catch (InterruptedException e) {
							System.out.println(Thread.currentThread().getName()+"被打断了");
						}
						// Thread.yield(); //暂停执行，放弃CPU控制权，进入就绪状态
					}
					System.out.println(Thread.currentThread().getName()
							+ "----" + i);
				}
			}
		}, "t");
		t.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 50; i++) {
//			if(i==3){
//				try {
//					t.join();  // t线程加入，主线程等待t线程执行完毕后再继续执行
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			System.out.println(Thread.currentThread().getName() + "----" + i);
		}
		
		t.interrupt(); // 中断t线程的休眠
	}
}
