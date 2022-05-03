package code13_集合.test04_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 统计一个字符串中每个字符出现的次数，保存到HashMap集合中
 * 
 * 通过排序，打印输出次数最多的前三个字符及次数
 */
public class 练习 {
	public static void main(String[] args) {
		String str = "asdfjk2348aaaauj;sdjf89234-8-asjsf";

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < str.length(); i++) {
			String c = str.charAt(i) + "";
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}
		System.out.println(map);
		
		// 获取所有键值对的集合
		Set<Entry<String, Integer>> entries = map.entrySet();
		// 将set集合转换为list集合
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(entries);
		
		Collections.sort(list,new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				if(o1.getValue()>o2.getValue()){
					return -1;
				}else if(o1.getValue()<o2.getValue()){
					return 1;
				}
				return 0;
			}
		});
		
		System.out.println(list);
		
		System.out.println("出现次数最多的前三个字符及次数：");
		for(int i=0;i<3;i++){
			Entry<String, Integer> entry = list.get(i);
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
	}
}
