package code15_IO.test02_字节流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Test05_对象输入输出流 {
	public static void main(String[] args) {
		test02();
	}

	// 序列化，写入对象
	public static void test01() {
		User u1 = new User(1001, "tom", 18);
		u1.setAddress(new Address("江苏", "南京"));
		User u2 = new User(1002, "jack", 21);
		u1.setAddress(new Address("江苏", "扬州"));
		List<User> users = Arrays.asList(u1, u2);

		ObjectOutputStream oos = null;
		try {
			// FileOutputStream fos = new FileOutputStream("user.data");
			// oos = new ObjectOutputStream(fos);
			oos = new ObjectOutputStream(new FileOutputStream("user.data"));

			// 写入对象
			// oos.writeObject(u1);
			// oos.writeObject(u2);
			oos.writeObject(users);
			oos.flush();

			System.out.println("写入对象成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close(); // 只需要关闭包装流
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 反序列化，读取对象
	public static void test02() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("user.data"));

			// 读取顺序和写入顺序一致
			// User u1 = (User) ois.readObject();
			// User u2 = (User) ois.readObject();
			// System.out.println(u1);
			// System.out.println(u2);
			List<User> list = (List<User>) ois.readObject();
			System.out.println(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
