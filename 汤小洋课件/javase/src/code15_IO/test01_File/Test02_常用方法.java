package code15_IO.test01_File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Test02_常用方法 {
	public static void main(String[] args) throws IOException {
		File file = new File("c.txt"); // 默认是相对于项目的根目录
		
		/*
		 * 访问属性
		 */
		System.out.println("文件名："+file.getName());
		System.out.println("路径名："+file.getPath());
		System.out.println("绝对路径名："+file.getAbsolutePath());
		System.out.println("父目录："+file.getParent());
		System.out.println("父目录文件对象："+file.getParentFile()); //返回的是File对象
		System.out.println("长度："+file.length());
		System.out.println("最后一次修改时间："+new Date(file.lastModified()));
		System.out.println("是否存在："+file.exists());
		System.out.println("是否可读："+file.canRead());
		System.out.println("是否可写："+file.canWrite());
		System.out.println("是否为普通文件："+file.isFile());
		System.out.println("是否为目录："+file.isDirectory());
		System.out.println("是否为隐藏文件："+file.isHidden());
		System.out.println(file); //直接输出File对象，本质上就是调用getPath()
		System.out.println("-----------------------------------------------");
		
		/*
		 * 文件目录的操作
		 */
		// boolean isSuccess = file.createNewFile(); //
		// 创建一个空文件，返回一个boolean，表示成功或失败
		// System.out.println(isSuccess);

		// file.renameTo(new File("c.txt")); //重命名
		
		// boolean isSuccess = file.delete(); //删除文件
		// System.out.println(isSuccess);
		
		
		File f = new File("D:/software");
		
		// boolean isSuccess = f.mkdir(); // 创建目录，如果父目录不存在 ，会导致创建失败
		// boolean isSuccess = f.mkdirs(); // 创建包括父目录的目录，即级联创建
		// System.out.println(isSuccess);
		
		String[] names = f.list(); // 获取目录下的所有文件和目录的名称
		System.out.println(Arrays.toString(names));
		
		File[] files = f.listFiles(); // 获取目录下的所有文件和目录的对象
		System.out.println(Arrays.toString(files));
		
		/*
		 * 常量
		 */
		System.out.println(File.separator);
	}
	
}
