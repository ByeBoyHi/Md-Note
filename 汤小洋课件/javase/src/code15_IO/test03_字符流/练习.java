package code15_IO.test03_字符流;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * 提示用户输入一段英文，将英文单词的首尾字母大写后逐行保存到文件a.txt中
 * WelcomE
 * TO
 * JavA
 */
public class 练习 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一段英文：");
		String str = input.nextLine();
		
		String[] arr = str.split("\\s+");
		
		try (PrintWriter writer = new PrintWriter("a.txt")){
			for (String s : arr) {
				String firstLetter = (s.charAt(0)+"").toUpperCase();
				String lastLetter = (s.charAt(s.length()-1)+"").toUpperCase();
				writer.println(firstLetter+s.substring(1, s.length()-1)+lastLetter);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
