package code16_线程.test08_生产者和消费者;

public class Test {
	public static void main(String[] args) {

		ProductPool pool = new ProductPool();

		Producer p1 = new Producer("p1", pool);
		Producer p2 = new Producer("p2", pool);
		Producer p3 = new Producer("p3", pool);
		Consumer c1 = new Consumer("c1", pool);
		Consumer c2 = new Consumer("c2", pool);

		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
	}
}
