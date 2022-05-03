package code07_面向对象;

public class Test03_this关键字 {
	public static void main(String[] args) {
		Account account1 = new Account();
		// account.queryMoney();
		account1.name="张三";
		account1.getMoney(); //此时this代表的是account1对象
		System.out.println();
		
		Account account2=new Account();
		account2.name="李四";
		account2.getMoney(); //此时this代表的是account2对象
		
	}
}

/*
 * 账户类
 */
class Account {
	/*
	 * 全局变量
	 */
	String name="tom"; // 有默认值，引用类型默认值为null，基本数据类型默认值为0、0.0、false等
	double money;

	// 查询余额
	public void queryMoney() {
		System.out.println("姓名：" + name + "，余额：" + money);

	}

	// 存钱
	public void saveMoney(double money) { //形参也是局部变量
		this.money += money;
	}

	// 取钱
	public void getMoney() {
		int a = 5; // 局部变量
		int b;
		System.out.println(a);
		// System.out.println(b); //必须先赋值才能访问
		
		String name="alice"; //局部变量name
		
		System.out.println("局部变量name："+name);
		System.out.println("全局变量name："+this.name);
		
		System.out.println(this.money);
	}
}
