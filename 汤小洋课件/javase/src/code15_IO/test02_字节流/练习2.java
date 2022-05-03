package code15_IO.test02_字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 文件的拆分和合并
 * jdk8_api_zh.zip_1
 * jdk8_api_zh.zip_2
 * jdk8_api_zh.zip_3
 */
public class 练习2 {
	public static void main(String[] args) {
		// splitFile("D:/backup/jdk8_api_zh.zip");
		mergeFile("D:/backup/jdk8_api_zh.zip_1");
	}

	// 拆分文件：一个输入流，多个输出流
	public static void splitFile(String filePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(filePath);

			byte[] buffer = new byte[1024 * 1024 * 10]; // 每次读取10M
			int num = -1;
			int index = 0;
			while ((num = fis.read(buffer)) != -1) {
				fos = new FileOutputStream(filePath + "_" + (++index));
				fos.write(buffer, 0, num);
				fos.flush();
				fos.close();
			}
			System.out.println("拆分成功，共拆分为：" + index + "个");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 合并文件：一个输出流，多个输入流
	public static void mergeFile(String filePath) {
		String basePath = filePath.substring(0, filePath.lastIndexOf("_"));

		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(basePath);
			int index = 1;
			File f = null;
			while ((f = new File(basePath + "_" + index++)).exists()) {
				fis = new FileInputStream(f);

				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fos.write(buffer);
				fos.flush();
				fis.close();
			}
			System.out.println("合并成功："+basePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
