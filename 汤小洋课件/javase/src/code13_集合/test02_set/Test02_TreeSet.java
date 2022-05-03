package code13_集合.test02_set;

import java.util.TreeSet;

public class Test02_TreeSet {

	public static void main(String[] args) {
		test02();
	}

	// 基本用法
	public static void test01() {
		TreeSet<String> set = new TreeSet<String>();

		set.add("def");
		set.add("abc");
		set.add("axy");
		
		System.out.println(set);
	}
	
	// 对元素进行排序
	public static void test02(){
		TreeSet<User> set = new TreeSet<User>(new UserComparator()); // 传入比较器
		
		set.add(new User("aaa", 24, 90));
		set.add(new User("bbb", 21, 92));
		set.add(new User("ccc", 18, 60));
		set.add(new User("ddd", 28, 89));
		set.add(new User("eee", 21, 99));
		set.add(new User("fff", 21, 99));
		
		System.out.println(set);
	}
}
