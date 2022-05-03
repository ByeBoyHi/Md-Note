package code15_IO.test01_File;

import java.io.File;

/*
 * 删除指定目录下所有的空目录，包括子目录下的空目录
 */
public class 练习 {
	public static void main(String[] args) {
		File file = new File("d:/resource");

		remove(file);
	}

	public static void remove(File file) {
		// 判断是否为空目录
		if (file.isDirectory() && file.listFiles().length == 0) {
			file.delete();
			System.out.println("删除空目录：" + file.getAbsolutePath());
			// 删除当前目录后可能导致父目录也为空，所以需要对父目录进行处理
			remove(file.getParentFile());
		} else if (file.isDirectory()) {
			// 如果当前目录不为空目录，则获取目录下所有文件进行再处理
			File[] files = file.listFiles();
			for (File f : files) {
				remove(f); // 递归删除
			}
		}

	}
}
