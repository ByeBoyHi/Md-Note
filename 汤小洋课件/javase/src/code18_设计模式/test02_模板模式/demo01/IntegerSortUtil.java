package code18_设计模式.test02_模板模式.demo01;

public class IntegerSortUtil extends SortUtil<Integer> {

	@Override
	public int compareTo(Integer o1, Integer o2) {
		return o2 - o1; // 降序
	}

}
