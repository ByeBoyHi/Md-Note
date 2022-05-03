package code13_集合.test01_List;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test05_性能对比 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list1.add(0, i); // 每次往最前面插入数据，会导致后面所有元素都移动
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");

		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list2.addFirst(i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2 + "ms");
	}
}
