package code15_IO.test02_字节流;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test04_字节数组输入输出流 {
	public static void main(String[] args) {
		test02();
	}
	
	// ByteArrayInputStream
	public static void test01(){
		byte[] data="welcome to java".getBytes();
		
		try {
			// 定义字节数组输入流，数据来源为字节数组
			InputStream is = new ByteArrayInputStream(data);
			
			int i=-1;
			while((i=is.read())!=-1){
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * ByteArrayInputStream和ByteArrayOutputStream不需要关闭
		 * 因为其操作的是内存中的字节数组，属于内存读写流，并非操作的外部资源
		 */
		
	}
	
	// ByteArrayOutputStream
	public static void test02(){
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			
			// 将数据写出到内置的字节数组中
			os.write("hello".getBytes());
			os.flush();
			
			// 获取内置的字节数组中的数据
			byte[] buffer = os.toByteArray();
			System.out.println(new String(buffer));
			System.out.println(os.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
