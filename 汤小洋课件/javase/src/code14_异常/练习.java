package code14_异常;

/*
 * 编写一个账户类，包含取款的方法，针对取款进行异常处理
 */
public class 练习 {
	public static void main(String[] args) {
		Account account = new Account("王思聪", 8888);
		
		try {
			account.withdraw(10000);
			System.out.println("取款成功！");
		} catch (InsufficientFundsException e) {
			System.out.println("取款失败："+e.getMessage());
		}
	}
}

/*
 * 账户类
 */
class Account {
	private String name;
	private double balance;

	public Account() {
		super();
	}

	public Account(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 取款
	public void withdraw(double money) throws InsufficientFundsException{
		if(money>balance){
			throw new InsufficientFundsException("余额不足");
		}
		balance=balance-money;
	}

}
