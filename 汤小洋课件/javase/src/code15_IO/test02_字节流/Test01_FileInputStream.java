package code15_IO.test02_字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Scanner;

public class Test01_FileInputStream {
	public static void main(String[] args) {
		test03();
	}
	
	// 基本用法
	public static void test01(){
		FileInputStream  fis=null;
		try {
			//fis = new FileInputStream("a.txt");
			fis = new FileInputStream(new File("a.txt"));
			
			/*int data = fis.read(); // 处于阻塞状态，读取一个字节，返回int类型的字节值，如果读取到末尾，则返回-1
			while(data!=-1){
				System.out.println((char)data);
				data=fis.read();
			}*/
			
			int data=-1;
			while((data=fis.read()) != -1){
				System.out.println((char)data);  // 字节流读取中文时可能会出现乱码
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){ // 需要判断是否为null，防止出现NullPointerException
				try {
					 // 关闭输入流：只要是打开了外部的资源（文件、数据库连接、网络连接），在使用后都需要关闭，释放资源
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	// 其他用法
	public static void test02(){
		// 在JDK7中，提供了一种新语法，叫做try-with-resource，能够自动关闭外部资源，不需要写finally，简化代码
		try(
			// 此处只能创建实现了AutoClosable接口的对象
			FileInputStream fis=new FileInputStream("a.txt");	
		){
			//System.out.println((char)fis.read());
			//System.out.println(fis.available()); // 流中可读取的字节数
			
			byte[] buffer=new byte[1024*1024]; // 减少对硬盘的读取次数，提高效率
//			int num = fis.read(buffer); // 一次性读取buffer.length个字节到buffer中，返回实际读取到的字节数，如果读取到末尾，则返回-1
//			System.out.println(num);
//			String str = new String(buffer);
//			System.out.println(str);
//			
//			num = fis.read(buffer);
//			System.out.println(num);
			//System.out.println(new String(buffer, 0, num));  // 将指定长度的字节数组转换为字符串
			
			int num=-1;
			while((num=fis.read(buffer)) != -1){
				System.out.println(new String(buffer,0,num));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	// 加载不同路径下的文件
	public static void test03(){
		try(
			// 默认加载项目根路径下
			//InputStream is=new FileInputStream("a.txt");  
				
			// 加载classpath类路径，即src目录
			//InputStream is=Test01_FileInputStream.class.getClassLoader().getResourceAsStream("b.txt"); 
				
			// 加载当前类所在目录
			InputStream is=Test01_FileInputStream.class.getResourceAsStream("c.txt");
		){
			System.out.println((char)is.read());
			System.out.println("加载文件成功！");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
