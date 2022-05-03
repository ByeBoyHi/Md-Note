package code18_设计模式.test02_模板模式.demo01;

import code18_设计模式.test02_模板模式.demo01.SortUtil;

public class StringSortUtil extends SortUtil<String> {

	@Override
	public int compareTo(String o1, String o2) {
		return o1.length() - o2.length(); // 升序
	}

}
