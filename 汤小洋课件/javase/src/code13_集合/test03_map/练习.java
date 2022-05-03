package code13_集合.test03_map;

import java.util.HashMap;
import java.util.Map;

/*
 * 统计一个字符串中每个字符出现的次数，保存到HashMap集合中
 */
public class 练习 {
	public static void main(String[] args) {
		String str = "asdfjk2348uj;sdjf89234-8-asjsf";

//		Map<String, Integer> map = new HashMap<String, Integer>();

		// 方式1
		/*for (int i = 0; i < str.length(); i++) {
			String c = str.charAt(i) + "";
//			if (map.containsKey(c)) {
//				// 如果出现该字符，则次数+1
//				int count = map.get(c);
//				count++;
//				map.put(c, count);
//			} else {
//				// 如果从示出现过，则设置次数为1
//				map.put(c, 1);
//			}
			map.put(c, map.containsKey(c)?map.get(c)+1:1);
		}
		System.out.println(map);*/
		
		// 方式2
//		while(!str.isEmpty()){
//			String c = str.charAt(0)+"";
//			String newStr = str.replace(c, "");
//			map.put(c,str.length()-newStr.length());
//			str=newStr;
//		}
//		System.out.println(map);
		
		// 方式3
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}
}
