package code05_方法;

public class Test05_Debug {
	public static void main(String[] args) {
		show();
	}

	public static void print() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello World");
		}
	}

	public static void show() {
		System.out.println("即将开始打印HelloWorld......");
		print();
		System.out.println("打印HelloWorld结束......");
	}
}
