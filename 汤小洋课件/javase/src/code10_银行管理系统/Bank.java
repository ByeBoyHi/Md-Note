package code10_银行管理系统;

/**
 * 
 * <银行管理系统>
 * @author 汤小洋
 * @date 2019年2月13日 上午10:24:12
 * @version v1.0
 */
public class Bank {
	// 存储所有银行账户
	static Account[] accounts = new Account[100];
	// 当前的账户数
	static int count = 0;

	/**
	 * 
	 * <开户>
	 * @param account
	 * @return 是否开户成功，true表示成功，false表示失败
	 * @date 2019年2月13日 上午10:24:31
	 */
	public static boolean register(Account account) {
		if (count < accounts.length) {
			accounts[count++] = account;
			return true;
		}
		return false;
	}

	/*
	 * 登陆
	 */
	public static Account login(long id, String password) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getId() == id
					&& accounts[i].getPassword().equals(password)) {
				return accounts[i];
			}
		}
		return null;
	}

	/*
	 * 统计所有账户总贷款额
	 */
	public static double getTotalLoan() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			if (accounts[i] instanceof Loanable) {
				Loanable loan = (Loanable) accounts[i];
				sum += loan.getLoan();
			}
		}
		return sum;
	}

	/*
	 * 根据账户号id查询账户
	 */
	public static Account findById(long id) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getId() == id) {
				return accounts[i];
			}
		}
		return null;
	}

}
