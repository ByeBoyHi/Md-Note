package code13_集合.test03_map;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

public class Test02_Hashtable {
	public static void main(String[] args) {
		/*
		 * Hashtable
		 */
		Hashtable<Integer, String> table = new Hashtable<Integer, String>();
		table.put(1, "tom");
		table.put(2, "jack");
		table.put(3, "alice");
		// table.put(null,null); //不允许为null，编译不报错，运行时报NullPointerException

		// 遍历
		// table.keySet();
		// table.values();
		// table.entrySet();
		
		// 使用Enumeration：keys()、elements()
		Enumeration<Integer> keys = table.keys();  // 获取key的枚举实例
		while(keys.hasMoreElements()){
			Integer key = keys.nextElement();
			String value = table.get(key);
			System.out.println("key:"+key+",value:"+value);
		}
		Enumeration<String> values = table.elements(); // 获取value的枚举实例

		System.out.println(table);

		/*
		 * HashMap
		 */
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(null, null);
		System.out.println(map);

	}
}
