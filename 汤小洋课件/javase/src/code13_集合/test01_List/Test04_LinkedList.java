package code13_集合.test01_List;

import java.util.LinkedList;

public class Test04_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("aaa");

		// addFirst() 在首部添加
		list.addFirst("bbb");

		// addLast() 在末尾添加
		list.addLast("ccc");

		// getFirst() 返回第一个
		System.out.println(list.getFirst());
		System.out.println(list.get(0));

		// getLast() 返回最后一个
		System.out.println(list.getLast());
		System.out.println(list.get(list.size() - 1));
		
		// removeFirst() 删除第一个
		list.removeFirst();
		
		// removeLast() 删除最后一个
		list.removeLast();

		System.out.println(list);

	}
}
