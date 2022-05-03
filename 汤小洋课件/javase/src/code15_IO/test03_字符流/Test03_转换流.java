package code15_IO.test03_字符流;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test03_转换流 {
	public static void main(String[] args) {
		try(
//			FileInputStream fis = new FileInputStream("a.txt");
//			InputStreamReader isr = new InputStreamReader(fis, "gbk");
//			BufferedReader reader=new BufferedReader(isr);	
			
			BufferedReader reader=new BufferedReader(
					new InputStreamReader(
							new FileInputStream("b.txt")
					,"gbk") // 以gbk编码读取文件
			);	
				
			// BufferedReader reader = new BufferedReader(new InputStreamReader(Test03_转换流.class.getClassLoader().getResourceAsStream("b.txt")));
				
//			BufferedWriter writer=new BufferedWriter(
//					new OutputStreamWriter(
//							new FileOutputStream("c.txt")
//					,"utf-8")  // 以utf-8编码写入文件
//			);	
			PrintWriter writer = new PrintWriter("c.txt", "utf-8"); 
		){
//			System.out.println(reader.readLine());
			writer.write(reader.readLine());
			System.out.println("复制文件成功");
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
}
