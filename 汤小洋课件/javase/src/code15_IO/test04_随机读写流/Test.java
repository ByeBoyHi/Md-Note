package code15_IO.test04_随机读写流;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {
	public static void main(String[] args) {
		try(
			/*
			 * 当文件不存在时：
			 * 		如果模式为r，会报异常FileNotFoundException
			 * 		如果模式为rw，会自动创建文件
			 */
			RandomAccessFile raf=new RandomAccessFile("x.txt", "rw"); //模式：r只读、rw读写
		){
			System.out.println(raf.getFilePointer()); // 获取当前指针的位置，从0开始
			
			raf.write("张三".getBytes()); //对于utf-8，一个汉字占3个字节
			raf.write("hello".getBytes());
			System.out.println(raf.getFilePointer()); // 11
			
			System.out.println("写入成功");
			
			raf.seek(8); // 将指针移动到指定的位置
			raf.write("李四".getBytes());
			System.out.println(raf.getFilePointer()); // 14
			
			raf.seek(6);
			byte[] buffer=new byte[2];
			raf.read(buffer);
			System.out.println(new String(buffer));
			System.out.println(raf.getFilePointer()); // 8
			
			raf.skipBytes(3); // 将指针向后跳过指定的字节，只能往前，不能倒退 ——>
			buffer=new byte[1024*1024];
			int num=-1;
			while((num=raf.read(buffer))!=-1){
				System.out.println(new String(buffer,0,num));
			}
			
			// 修改数据
			raf.seek(8);
			raf.write("赵".getBytes());
			System.out.println("修改成功");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
