package code16_线程.test08_生产者和消费者;

/*
 * 消费者
 */
public class Consumer extends Thread {

	private String name; // 消费者名称
	private ProductPool pool; // 商品池

	public Consumer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.isEmpty()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					pool.get();
					System.out.println(this.name + "消费了一个商品，现在商品数量是："
							+ pool.getNum());
					pool.notifyAll();
				}
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
