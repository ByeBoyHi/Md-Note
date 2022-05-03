package code11_常用类.test02_String;

import java.util.Scanner;

public class Homewk {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("请输入会员生日<月/日: 00/00 >: ");
			String birth = input.next();
			if (birth.length() > 2 && birth.length() < 6) {
				if (birth.substring(1, 2).equals("/") || birth.substring(2, 3).equals("/")) {
					System.out.println("该会员生日是: " + birth);
					break;
				}
			} 
				System.out.println("生日形式输入错误！");
				continue;
		}
		
		while(true) {
			System.out.print("请输入会员密码<6~10位>: ");
			String pwd = input.next();
			if(pwd.length()>=6 && pwd.length()<=10) {
				System.out.println("该会员密码是: " + pwd);
				break;
			}else {
				System.out.println("密码形式输入错误！");
				continue;
			}
		}

	}

}
