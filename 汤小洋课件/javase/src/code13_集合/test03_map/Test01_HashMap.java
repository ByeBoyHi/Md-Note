package code13_集合.test03_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import code13_集合.test02_set.Student;

public class Test01_HashMap {
	public static void main(String[] args) {
		test02();
	}

	// 基本用法
	public static void test01() {
		// 创建一个HashMap集合，存储键值对
		HashMap<Integer, String> map = new HashMap<>(); // 第一个泛型为key的类型，第二个泛型为value的类型

		// put() 添加
		map.put(11, "aaa"); // 由两部分组成：键key、值value
		map.put(2, "bbb");
		map.put(23, "ccc");
		map.put(1, "ddd"); // key是唯一的，当key已存在时表示修改对应的value
		map.put(5, "ccc");
		System.out.println(map);

		// get() 获取
		String value = map.get(5); // 根据key获取对应的value
		System.out.println(value);

		// remove() 删除
		// map.remove(2); //根据key删除对应的键值对

		// containsKey() 判断是否包含指定的key
		System.out.println(map.containsKey(11));

		// containsValue() 判断是否包含指定的value
		System.out.println(map.containsValue("xxx"));

		// isEmpty() 判断是否为空
		System.out.println(map.isEmpty());

		// size() 元素个数
		System.out.println(map.size());

		// clear() 清空
		map.clear();

		System.out.println(map);

	}

	// 遍历
	public static void test02() {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();

		Student stu1 = new Student(1001, "tom");
		Student stu2 = new Student(1002, "jack");
		Student stu3 = new Student(1003, "mike");

		// 将学号作为key，将学生对象作为value
		map.put(stu1.getNo(), stu1);
		map.put(stu2.getNo(), stu2);
		map.put(stu3.getNo(), stu3);

		// Map本身无法遍历

		/*
		 * 方式1：遍历所有的key
		 */
		Set<Integer> keys = map.keySet(); // 返回所有kery的集合
		for (Integer key : keys) {
			Student value = map.get(key);
			System.out.println("key:" + key + ",value:" + value);
		}
		System.out.println("--------------------------------");
		
		/*
		 * 方式2：遍历所有的value
		 */
		Collection<Student> values = map.values();
		for (Student value : values) {
			System.out.println(value);
		}
		System.out.println("--------------------------------");
		
		/*
		 * 方式3：遍历所有的key-value
		 * Map.Entry就表示key-value
		 * 	返回一个Set集合，Set集合的泛型是Map.Entry类型
		 * 	Map.Entry的泛型是Map集合的泛型
		 */
		Set<Map.Entry<Integer, Student>> entries = map.entrySet();
		Iterator<Entry<Integer, Student>> it = entries.iterator();
		while(it.hasNext()){
			Entry<Integer, Student> entry = it.next(); //获取Entry（key、value）
			Integer key = entry.getKey();
			Student value = entry.getValue();
			System.out.println("key:"+key+",value:"+value);
		}
		
	}
}
