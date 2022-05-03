package code16_线程.test09_线程单例;

import java.util.HashMap;
import java.util.Map;

/*
 * 线程单例
 */
public class MyThreadLocal<T> {

	private Map<Thread, T> map = new HashMap<>();

	public void set(T t) {
		map.put(Thread.currentThread(), t); // 将当前线程作为Key
	}

	public T get() {
		return map.get(Thread.currentThread());
	}
}
