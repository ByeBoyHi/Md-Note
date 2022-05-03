package code11_常用类.test03_StringBuffer和StringBuilder;

public class Test01_用法 {
	public static void main(String[] args) {
		/*
		 * String是不可变的，会在内存中产生许多String对象
		 */
		// String s = "";
		// while (true) {
		// s += "hello";
		// }

		/*
		 * 使用StringBuilder和StringBuffer
		 */
		// 创建一个StringBuffer对象，为空字符串
		// StringBuffer buffer=new StringBuffer();
		// 创建一个StringBuffer对象，存储字符串hello
		StringBuffer buffer = new StringBuffer("hello");
		System.out.println(buffer);

		// append()
		buffer.append("aaa"); // 向末尾添加，直接在buffer对象上进行修改，不会创建新对象
		buffer.append("bbb").append("ccc").append(666).append(true); //链式写法
		System.out.println(buffer);
		
		// insert()
		buffer.insert(1, "ddd");
		System.out.println(buffer);
		
		// delete()
		buffer.delete(3,5); //删除索引为[3,5)的字符
		System.out.println(buffer);
		
		// deleteCharAt()
		buffer.deleteCharAt(2);
		System.out.println(buffer);
		
		// setCharAt()
		buffer.setCharAt(1, 'X');
		System.out.println(buffer);
		
		// setLength()
		buffer.setLength(5); // 设置保留的字符串长度
		System.out.println(buffer);
		
		// reverse()
		buffer.reverse();
		System.out.println(buffer);
		
		// toString()
		String str = buffer.toString(); // 将StringBuffer转换为String
		System.out.println(str);
		
		
		/*
		 * 以下方法的使用与String相同
		 * length()、charAt()、indexOf()、lastIndexOf()、substring、replace()
		 */
		
		
		
		
		

	}
}
