package code11_常用类.test02_String;

import java.util.Scanner;

/*
 * 提示用户输入字符串
 * 1.计算字符串包含多少个数字、英文字母以及其他字符
 * 2.计算字符串中字母a出现的次数
 * 
 * Scanner类的next()和nextLine()
 * next()：把空格、Tab、回车等作为结束标记，无法获取空格
 * nextLine()：表示获取一整行，只把回车作为结束标记，可以获取空格
 */
public class 练习3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("请输入字符串：");
		String str = input.next();
		
		/*
		 * 1.计算字符串包含多少个数字、英文字母以及其他字符
		 */
//		str=str.toUpperCase();
//		int count1 = 0, count2 = 0, count3 = 0;
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if (c >= '0' && c <= '9') {
//				count1++;
//			} else if (c >= 'A' && c <= 'Z') {
//				count2++;
//			} else {
//				count3++;
//			}
//		}
//		System.out
//				.println("数字：" + count1 + "，字母：" + count2 + "，其他字符：" + count3);
		
		/*
		 * 2.计算字符串中字母a出现的次数
		 */
		int count=0;

		//方法1
//		char[] arr = str.toCharArray();
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i]=='a'){
//				count++;
//			}
//		}
		
		//方法2
//		String[] arr = str.split("");
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i].equals("a")){
//				count++;
//			}
//		}
		
		//方法3
//		for (int i = 0; i < str.length(); i++) {
//			if(str.charAt(i)=='a'){
//				count++;
//			}
//		}
		
		//方法4 abcax
		for (int i = 0; i < str.length(); i++) {
			i = str.indexOf('a',i);
			if(i==-1){
				break;
			}
			count++;
		}
		
		System.out.println(count);
		
	}
}
