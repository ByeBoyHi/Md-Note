package code15_IO.test03_字符流;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * System.out 标准输出流，默认为显示器
 * System.in  标准输入流，默认为键盘
 */
public class Test02_缓冲输入输出流 {
	public static void main(String[] args) {
		try(
			BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
			//BufferedWriter writer = new BufferedWriter(new FileWriter("aaaa.txt"));
			PrintWriter writer=new PrintWriter("aaaa.txt");
				
		){
			//String data = reader.readLine(); // 每次读取一次，读不到数据时返回null
			//System.out.println(data);
			
			String data=null;
			while((data=reader.readLine())!=null){
				//writer.write(data);
				//writer.newLine(); //插入换行符
				//writer.write("\r\n"); // 也可以插入\r\n进行换行
				
				writer.println(data); // 写入并换行，更方便
				
			}
			System.out.println("复制文件成功");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
