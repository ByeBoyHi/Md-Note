package code15_IO.test03_字符流;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/*
 * FileReader、FileWriter的用法与FileInputStream、FileOutputStream类似
 * 前者是以字符为单位，后者是以字节为单位
 * 
 * 字符流无法读写二进制文件
 */
public class Test01_文件输入输出流 {
	public static void main(String[] args) {
		try(
			Reader reader=new FileReader("a.txt");
			Writer writer = new FileWriter("aaa.txt")	
		){
			//int data = reader.read(); // 每次读取一个字符，返回int类型的字符值
			//System.out.println((char)data);
			
			char[] buffer=new char[5];
			int num = -1;
			while((num=reader.read(buffer))!=-1){
				writer.write(buffer, 0, num);
			}
			System.out.println("复制文件成功");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
