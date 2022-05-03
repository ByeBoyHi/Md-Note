package code11_常用类.test02_String;

import java.util.Arrays;

public class Test02_常用方法 {
	public static void main(String[] args) {
		String str = "aEllo woRld";

		// length()
		System.out.println("字符串长度：" + str.length());

		// indexOf()
		System.out.println("字符o第一次出现的位置：" + str.indexOf('o')); // 索引从0开始，如果找不到则返回-1
		System.out.println("字符串wo第一次出现的位置：" + str.indexOf("wo"));
		System.out.println("从索引为6的位置开始后向查找字符o第一次出现的位置：" + str.indexOf('o', 6));

		// lastIndexOf()
		System.out.println("字符o最后一次出现的位置：" + str.lastIndexOf('o'));

		// substring()
		System.out.println("获取索引为[3,7)之间的子串：" + str.substring(3, 7)); // 左闭右开
		System.out.println("获取索引为3到结尾的子串：" + str.substring(3));

		// charAt()
		System.out.println("获取索引为1的字符：" + str.charAt(1));

		// concat()
		System.out.println("在字符串后拼接abc" + str.concat("abc"));

		// startsWith()
		System.out.println("是否以he开头：" + str.startsWith("he"));

		// endsWith()
		System.out.println("是否以abc结尾：" + str.endsWith("abc"));

		// contains()
		System.out.println("是否包含el：" + str.contains("el"));

		// isEmpty()
		System.out.println("是否为空字符串：" + str.isEmpty()); // 本质上就是判断str.length==0
		System.out.println("是否为null：" + str == null);

		// equals()
		String str2 = new String("hello World");
		System.out.println("地址是否相同：" + str == str2);
		System.out.println("内容是否相同：" + str.equals(str2));

		// equalsIgnoreCase
		System.out.println("忽略大小的话，内容是否相同：" + str.equalsIgnoreCase(str2));

		// toUpperCase()
		System.out.println("转换为大写：" + str.toUpperCase());

		// toLowerCase()
		System.out.println("转换为小写：" + str.toLowerCase());

		// replace()
		System.out.println("将字符o替换为x：" + str.replace('o', 'x')); // 返回一个新字符串
		System.out.println(str); // 原字符串没有变化

		// trim()
		System.out.println("去除两边的空格："+str.trim());
		
		// split()
		String[] arr1 = str.split(" ");
		System.out.println("以空格进行分割："+Arrays.toString(arr1));
		System.out.println("以o进行分割："+Arrays.toString(str.split("o")));
		
		//toCharArray()
		System.out.println("-----将字符串转换为字符数组--------");
		char[] chars = str.toCharArray();
		System.out.println(Arrays.toString(chars));
		System.out.println("-----将字符数组转换为字符串--------");
		String str3 = new String(chars);
		System.out.println(str3);
		
		// getBytes()
		System.out.println("-----将字符串转换为字节数组--------");
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));
		System.out.println("-----将字节数组转换为字符串--------");
		String str4 = new String(bytes);
		System.out.println(str4);
	}
}
