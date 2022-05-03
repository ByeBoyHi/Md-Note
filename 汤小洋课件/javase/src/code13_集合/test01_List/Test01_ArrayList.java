package code13_集合.test01_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test01_ArrayList {
	public static void main(String[] args) {
		test03();
	}

	// 基本用法
	public static void test01() {
		// 创建一个ArrayList集合，默认集合中元素为Object类型
		ArrayList list = new ArrayList();
		// 向集合中添加元素
		list.add("tom");
		list.add(18);
		list.add(120.5);
		list.add(true);
		list.add(new Object());
		list.add(null);

		// 创建一个泛型集合，指定集合中元素的类型
		List<String> list2 = new ArrayList<>();
		list2.add("tom");

		System.out.println(list);
	}

	// 常用方法
	public static void test02() {
		ArrayList<String> list = new ArrayList<String>();

		// add() 添加元素
		list.add("tom"); // 向末尾添加，有序（元素顺序与放入顺序一致）
		list.add("jack");
		list.add("mike");
		list.add("tom"); // 允许重复
		list.add(2, "alice"); // 向指定索引位置添加，索引从0开始
		System.out.println(list);

		// set() 修改
		// String str = list.set(0, "lucy"); // 返回被修改的元素
		// System.out.println(str);

		// remove() 删除
		// boolean flag = list.remove("tom"); // 根据元素值删除，返回boolean，表示成功或失败
		// System.out.println(flag);
		// String str = list.remove(1); // 根据索引删除，返回被删除的元素
		// System.out.println(str);

		// get() 获取
		System.out.println(list.get(1));

		// size() 集合大小/长度，即元素个数
		System.out.println(list.size());

		// isEmpty() 是否为空
		System.out.println(list.isEmpty());
		System.out.println(list.size() == 0);

		// indexOf() 指定元素在集合中的索引
		System.out.println(list.indexOf("tom"));
		System.out.println(list.lastIndexOf("aaa")); // 如果不存在，则返回-1

		// contains() 是否包含指定元素
		System.out.println(list.contains("aaa"));

		// clear() 清空
		// list.clear();

		// toArray() 将list转换为数组
		// Object[] arr = list.toArray();
		// System.out.println(Arrays.toString(arr));

		// 将数组转换为list
		String[] arr = { "aaa", "bbb", "ccc" };
		List<String> list2 = Arrays.asList(arr);
		List<String> list3 = Arrays.asList("aaa", "bbb", "ccc");
	}

	// 遍历集合
	public static void test03() {
		List<Integer> list = Arrays.asList(12, 4, 65, 8, 2);

		// 方式1
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+"\t");
		}
		System.out.println();
		
		// 方式2
		for(Integer num:list){
			System.out.print(num+"\t");
		}
		System.out.println();
		
		// 方式3，使用Iterator迭代器，用于遍历集合中所有元素的一种类型（只要实现了Iterable接口的类都可以使用迭代器进行遍历）
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){ // 判断是否有下一个元素
			Integer num = it.next(); //获取下一个元素
			System.out.print(num+"\t");
		}
		
	}

}
