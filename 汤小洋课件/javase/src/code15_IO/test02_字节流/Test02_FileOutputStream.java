package code15_IO.test02_字节流;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_FileOutputStream {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			// 如果文件不存在，会自动创建文件，如果文件存在，默认会覆盖原文件的内容
			// fos=new FileOutputStream("a.txt");
			fos = new FileOutputStream("a.txt", true); // true表示以追加的形式写数据

			byte[] data = "hello world".getBytes();
			fos.write(data); // 写入数据，只是将数据写入到内存的缓冲区中，并没有真正写入到文件中
			fos.flush(); // 刷新输出流，完成数据的输出，当关闭流时会自动调用该方法

			System.out.println("写入数据成功");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
