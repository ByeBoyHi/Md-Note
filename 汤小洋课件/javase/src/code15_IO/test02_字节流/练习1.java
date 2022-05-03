package code15_IO.test02_字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * 复制指定目录下所有文件到目标目录
 */
public class 练习1 {
	public static void main(String[] args) {
		copyFile("C:/Users/User/workspace/javase/resource","d:/backup");
	}

	
	private static void copyFile(String srcPath, String destPath) {
		File srcFile = new File(srcPath);
		File destFile = new File(destPath);
		
		if(srcFile.isDirectory()){
			destFile=new File(destPath+File.separator+srcFile.getName());
			destFile.mkdirs();
			
			File[] files = srcFile.listFiles();
			for (File file : files) {
				copyFile(file.getAbsolutePath(), destFile.getAbsolutePath());
			}
		}else if(srcFile.isFile()){
			try(
				InputStream is=new FileInputStream(srcFile);
				OutputStream os=new FileOutputStream(destPath+File.separator+srcFile.getName());
			){
				byte[] buffer=new byte[1024*1024];
				int num=-1;
				while((num=is.read(buffer))!=-1){
					os.write(buffer, 0, num);
				}
				System.out.println("复制"+srcPath);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
