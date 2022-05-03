package code13_集合.test02_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test01_HashSet {
	public static void main(String[] args) {
		test02();
	}

	// 基本用法
	public static void test01() {
		HashSet<String> set = new HashSet<String>();

		set.add("aaa"); // 无序
		set.add("bbb");
		set.add("ccc");
		set.add("ddd");
		set.add("aaa"); // 相同的元素不会添加到set集合中

		System.out.println(set);

		/*
		 * Set集合不能按索引访问，因为元素的存储顺序是无序的，不保证元素的顺序与放入的顺序一致，所以没有索引
		 */

		/*
		 * 常用方法
		 */
		// size()、isEmpty()、clear()、remove、contains()、iterator()、toArray()

		// addAll() 将list转换为set
		List<String> list = Arrays.asList("a", "b", "c", "a", "b", "a");
		set.addAll(list);
		
		HashSet<String> set2 = new HashSet<String>(list);
		System.out.println(set2);
	}

	// 判断元素是否重复
	public static void test02(){
		Set<Student> set=new HashSet<Student>();
		
		Student s1 = new Student(1001, "tom");
		Student s2 = new Student(1001, "tom");
		set.add(s1);
		set.add(s2);
		
		System.out.println(set);
	}
}
