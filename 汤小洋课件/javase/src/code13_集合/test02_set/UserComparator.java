package code13_集合.test02_set;

import java.util.Comparator;

/*
 * 自定义比较器，用来比较User对象
 */
public class UserComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
		// 根据分数进行比较，降序
		if(u1.getScore()>u2.getScore()){
			return -1;
		}else if(u1.getScore()<u2.getScore()){
			return 1;
		}
		return 0;
	}

}
