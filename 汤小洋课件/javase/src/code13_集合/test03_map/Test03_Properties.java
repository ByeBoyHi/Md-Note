package code13_集合.test03_map;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Test03_Properties {
	public static void main(String[] args) throws IOException {
		test03();
	}

	// 基本用法
	public static void test01() {
		Properties p = new Properties();

		// 一般不会这样用
		// p.put(1, "tom");
		// p.get(1);

		// setProperty() 设置属性
		p.setProperty("name", "admin");
		p.setProperty("age", "20");
		p.setProperty("sex", "male");

		// getProperty() 获取属性
		System.out.println(p.getProperty("name")); // 根据属性名获取属性值，返回String类型

		// 遍历
		// p.keySet()
		// p.values()
		// p.entrySet()
		
		Enumeration<Object> keys = p.keys();
		// Enumeration<Object> values = p.elements();
		//Enumeration<?> keys = p.propertyNames(); // ?是泛型通配符
		while(keys.hasMoreElements()){
			String key = (String) keys.nextElement();
			String value = p.getProperty(key);
			System.out.println(key+"="+value);
		}
		
	}

	// 读取属性文件到Properties集合中
	public static void test02() throws IOException{
		Properties p = new Properties();
		
		/*
		 * 加载属性文件（实际上，只要文件内容是：属性名=属性值 的格式，都可以加载，与文件的后缀名无关）
		 */
		p.load(
			Test03_Properties.class // 获取当前类的Class对象
				.getClassLoader() // 获取类加载器，用于加载classpath类路径下的资源，即src目录下
				.getResourceAsStream("data.properties") // 加载类路径下的指定的文件
		); // 暂时记住，固定写法
		//p.load(Test03_Properties.class.getClassLoader().getResourceAsStream("data.properties"));
		
		System.out.println(p);
		System.out.println(p.getProperty("name"));
	}
	
	// 查看系统属性
	public static void test03(){
		// 获取系统的属性集合
		Properties p = System.getProperties();
		
		Enumeration<Object> e = p.keys();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			String value=p.getProperty(key);
			System.out.println(key+"="+value);
		}
		
		System.out.println(System.getProperty("java.home"));;
		System.out.println(System.getProperty("file.encoding"));
	}
	
	
	
	
	
	
}
