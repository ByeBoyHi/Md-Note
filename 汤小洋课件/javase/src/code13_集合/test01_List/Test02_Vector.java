package code13_集合.test01_List;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Test02_Vector {
	public static void main(String[] args) {
		Vector<Integer> nums = new Vector<Integer>();
		nums.add(7);
		nums.add(76);
		nums.add(3);
		nums.add(9);
		nums.add(7);
		nums.add(17);
		System.out.println(nums);

		/*
		 * 遍历
		 */
		for (int i = 0; i < nums.size(); i++) {
			System.out.print(nums.get(i) + "\t");
		}
		System.out.println();

		for (Integer num : nums) {
			System.out.print(num + "\t");
		}
		System.out.println();

		/*
		 * Iterator用来替代Enumeration
		 */
		Iterator<Integer> it = nums.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "\t");
		}
		System.out.println();

		/*
		 * 使用Enumeration枚举，适用于Vector、Hashtable、Properties等集合，已过时
		 */
		Enumeration<Integer> e = nums.elements();
		while (e.hasMoreElements()) { // 判断是否还有更多元素
			Integer num = e.nextElement(); // 获取元素
			System.out.print(num + "\t");
		}
		
	}
}
