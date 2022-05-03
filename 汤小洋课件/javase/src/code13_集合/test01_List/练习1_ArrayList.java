package code13_集合.test01_List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * 提示用户输入整数，存放到ArrayList集合中，输入0代表结束
 * 分别使用for、foreach、iterator循环集合，并删除所有是3的倍数的元素
 */
public class 练习1_ArrayList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<Integer> list = new ArrayList<Integer>();

		while (true) {
			System.out.print("请输入整数（0表示结束）：");
			int num = input.nextInt();
			if (num == 0) {
				break;
			}
			list.add(num);
		}

		// 使用for
//		for (int i = list.size() - 1; i >= 0; i--) {
//			int num = list.get(i);
//			if (num % 3 == 0) {
//				// list.remove(i); //当参数为int时表示按索引删除
//				list.remove(new Integer(num)); // 当参数为Integer包装类型时按元素值删除
//			}
//		}
		
		/*
		 * 问题：使用foreach或iterator进行循环时，不能直接对集合进行remove()操作，报错ConcurrentModificationException
		 * 解决：
		 * 1.使用for循环
		 * 2.使用iterator提供的remove()方法
		 */
		// foreach
//		for (Integer num : list) {
//			if(num%3==0){
//				list.remove(new Integer(num)); //报错ConcurrentModificationException
//			}
//		}
		
		//iterator
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer num = it.next(); // 报错ConcurrentModificationException
			if(num%3==0){
				//list.remove(num);
				it.remove(); // 使用迭代器时如果要删除迭代的元素，必须使用迭代器的删除方法，表示删除当前迭代的元素
			}
		}
		

		System.out.println(list);
	}
}
