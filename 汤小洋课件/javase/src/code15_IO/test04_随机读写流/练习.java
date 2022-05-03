package code15_IO.test04_随机读写流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 实现文件的加密
 * 	a.txt ——> a.txt.sec
 * 
 * 思路：读取文件中的每个字节，与pwd进行异或的操作
 */
public class 练习 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入文件路径：");
		String filePath=input.nextLine();
		System.out.print("请输入密码：");
		int pwd = input.nextInt();
		secret(filePath, pwd);
		System.out.println("加密成功");
		
	}
	
	public static void secret(String filePath,int pwd){
		try(
			FileInputStream fis=new FileInputStream(filePath);
			FileOutputStream fos = new FileOutputStream(filePath+".sec");
		){
			int data=-1;
			while((data=fis.read())!=-1){
				fos.write(data ^ pwd);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
