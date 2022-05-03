package code15_IO.test01_File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/*
 * 文件过滤器，进行文件的过滤
 */
public class Test03_文件过滤器 {
	public static void main(String[] args) {
		File file = new File("d:\\resource");
		
		String[] list = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// 定义过滤规则
				if(name.endsWith(".jpg")||name.endsWith(".gif")||name.endsWith(".png")){
					return true;
				}
				return false;
			}
		});
		
		System.out.println(Arrays.toString(list));
	}
}
