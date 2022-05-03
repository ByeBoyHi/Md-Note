package code15_IO.test01_File;

import java.io.File;
import java.net.URISyntaxException;

/*
 * 关于File对象
 * 1.一个File对象指向一个路径
 * 2.这个路径可以是文件，也可以是目录
 * 3.这个路径所指向的文件可以存在，也可以不存在
 * 4.创建File对象时只是创建一个指向某个路径的对象，并不表示在硬盘中创建文件
 */
public class Test01_构造方法 {
	public static void main(String[] args) throws URISyntaxException {
		/*
		 * 创建一个File对象
		 */
		// 方式1：指定文件的全路径
		// File file=new File("D:\\resource\\a.txt"); // 绝对路径
		// File file = new File("D:/resource/a.txt");
		// File file = new File("/home/soft01/a.txt");
		// File file = new File("a.txt"); //相对路径

		// 方式2：指定父目录的路径和文件名
		// File file = new File("D:/resource", "code/a.txt");

		// 方式3：指定父目录的File对象和文件名
		// File file = new File(new File("D:/resource"), "a.txt");
		
		// 方式4：指定URI统一资源标识符
		File file = new File(
				Test01_构造方法.class
					.getClassLoader() // 获取类加载器
					.getResource("data.properties") // 加载类路径下的文件，返回URL（Uniform Resource Locator统一资源定位符）
					.toURI() // 转换为URI（Uniform Resource Identifier统一资源标识符）
		);

		System.out.println(file);
		System.out.println(file.exists()); //判断指定路径的文件是否存在 
	}
}
