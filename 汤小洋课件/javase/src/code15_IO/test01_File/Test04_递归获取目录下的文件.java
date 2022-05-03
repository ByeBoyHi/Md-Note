package code15_IO.test01_File;

import java.io.File;

/*
 * 递归获取目录下的所有文件，包括子目录下的文件 
 */
public class Test04_递归获取目录下的文件 {
	public static void main(String[] args) {
		File file = new File("d:/resource");
		
		display(file);
	}

	public static void display(File file) {
		// 判断文件是否存在
		if (!file.exists()) {
			return;
		}

		// 判断是否为目录
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if(f.isFile()){
					System.out.println(f.getAbsolutePath());
				}else{
					display(f);
				}
			}
		}else{
			System.out.println(file.getAbsolutePath());
		}
	}
}
