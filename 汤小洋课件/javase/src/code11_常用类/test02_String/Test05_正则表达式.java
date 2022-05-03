package code11_常用类.test02_String;

import java.util.Arrays;

public class Test05_正则表达式 {
	public static void main(String[] args) {
		char c = 0;
		String s = new String(new char[]{c});
		System.out.println("s=" + s + ".");
		System.out.println("aaabbb".matches("(a|b)*")); // 只能是a或b，位数任意
		System.out.println("heLlo".matches("[a-z]{1,}")); // 只能是小写字母，至少有1位
		System.out.println("1238".matches("\\d+")); // 第一个\表示字符串转义符，第二个\表示正则转义符
		System.out.println("hello123".matches("[a-z]{3,}\\w{1,5}")); // 前面至少有3位小写字母，后面跟1-5位的数字、字母、下划线
		
		System.out.println("hel23lo5".replaceAll("\\d{2}", "xy"));
		System.out.println("hel23lo5".replaceFirst("\\d", "x"));
		System.out.println(" welcome to_nanjing-hello$world  ".replaceAll("\\s|_|-|\\$",""));
		
		System.out.println(Arrays.toString("h23el6lo".split("\\d+")));  // h el lo
		System.out.println(Arrays.toString("hello world_welcome_to-nanjing".split("\\s|_|-"))); //根据空格或_或- 进行分割
	}
}
