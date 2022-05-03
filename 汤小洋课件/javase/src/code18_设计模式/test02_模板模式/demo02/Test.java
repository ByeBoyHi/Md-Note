package code18_设计模式.test02_模板模式.demo02;

import java.util.Arrays;
import java.util.Comparator;

import code18_设计模式.test02_模板模式.demo01.IntegerSortUtil;
import code18_设计模式.test02_模板模式.demo01.StringSortUtil;

public class Test {

	public static void main(String[] args) {
		Integer[] arr = { 12, 4, 65, 2, 7 };
//		SortUtil.sort(arr, new Comparator<Integer>() {
//			@Override
//			public int compareTo(Integer o1, Integer o2) {
//				return o1-o2;
//			}
//		});
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		System.out.println(Arrays.toString(arr));
		
		
		String[] arr2={"aa123","bbb","cccc"};
//		SortUtil.sort(arr2, new Comparator<String>() {
//			@Override
//			public int compareTo(String o1, String o2) {
//				return o1.length()-o2.length();
//			}
//		});
		System.out.println(Arrays.toString(arr2));
		
		
	}
}
