package code13_集合.test04_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(12);
		list.add(3);
		list.add(8);
		list.add(5);
		list.add(11);
		System.out.println(list);
		
		// addAll() 添加
		Collections.addAll(list, 111,222,333);
		
		// max() 最大值
		System.out.println(Collections.max(list));
		
		// min() 最小值
		System.out.println(Collections.min(list));
		
		// sort() 排序，升序
		// Collections.sort(list);
		
		Collections.sort(list, new Comparator<Integer>() { // 自定义比较器

			@Override
			public int compare(Integer o1, Integer o2) {
				// 降序
				if(o1>o2){
					return -1;
				}else if(o1<o2){
					return 1;
				}
				return 0;
			}
		});
		
		// reverse() 反转
		Collections.reverse(list);
		
		// replaceAll() 替换
		Collections.replaceAll(list, 111, 666);
		
		// swap() 交换
		Collections.swap(list, 0, list.size()-1);
		
		// fill() 填充/初始化
		Collections.fill(list, 0);
		
		System.out.println(list);
	}
}
