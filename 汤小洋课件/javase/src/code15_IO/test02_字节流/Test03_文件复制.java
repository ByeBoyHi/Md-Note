package code15_IO.test02_字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test03_文件复制 {
	public static void main(String[] args) {
		test01();
	}
	
	/*
	 * 每次复制一个字节
	 */
	public static void test01(){
		InputStream is=null;
		OutputStream  os=null;
		
		try {
			is = new FileInputStream("a.txt");
			os = new FileOutputStream("aa.txt");
			
			int data=-1;
			while((data=is.read())!=-1){
				os.write(data); // 读一个字节，写一个字节
			}
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * 每次复制多个字节
	 */
	public static void test02(){
		try(
			InputStream is=new FileInputStream("D:/software/jdk-8u151-windows-x64.zip");
			OutputStream os = new FileOutputStream("D:/software/jdk.zip");
		){
			byte[] buffer=new byte[1024*1024];
			int num=-1;
			while((num=is.read(buffer))!=-1){
				os.write(buffer, 0, num);
			}
			System.out.println("文件复制成功");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
