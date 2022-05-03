package code16_线程.test08_生产者和消费者;

/*
 * 生产者
 */
public class Producer extends Thread {

	private String name; // 生产者名称
	private ProductPool pool; // 商品池

	public Producer(String name, ProductPool pool) {
		this.name = name;
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (pool) {
				if (pool.isFull()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					pool.put();
					System.out.println(this.name + "生产了一个商品，现在商品数量："
							+ pool.getNum());
					pool.notifyAll();
				}
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
