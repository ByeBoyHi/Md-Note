package code10_银行管理系统;

/*
 * 账户类
 */
public abstract class Account {
	private static long currentID = 1000; // 记录当前编号

	private long id;
	private String password;
	private String name;
	private String personID;
	private String email;
	private double balance;

	public Account() {
		this.id = ++currentID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 存款
	public final void deposit(double money) {
		this.balance += money;
	}

	// 取款
	public abstract boolean withdraw(double money);

}
