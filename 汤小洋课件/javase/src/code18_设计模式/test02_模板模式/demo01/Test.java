package code18_设计模式.test02_模板模式.demo01;

import java.util.Arrays;

import code18_设计模式.test02_模板模式.demo01.IntegerSortUtil;
import code18_设计模式.test02_模板模式.demo01.StringSortUtil;

public class Test {

	public static void main(String[] args) {
		Integer[] arr = { 12, 4, 65, 2, 7 };
		SortUtil<Integer> util=new IntegerSortUtil();
		util.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		String[] arr2={"aa123","bbb","cccc"};
		SortUtil<String> util2=new StringSortUtil();
		util2.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		
	}
}
