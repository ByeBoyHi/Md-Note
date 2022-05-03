package code10_银行管理系统;

/*
 * 储蓄账户类
 */
public class SavingAccount extends Account {

	@Override
	public boolean withdraw(double money) {
		if (getBalance() >= money) {
			setBalance(getBalance() - money);
			return true;
		}
		return false;
	}

}
