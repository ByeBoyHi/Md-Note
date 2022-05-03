package code10_银行管理系统;

/*
 * 信用账户类
 */
public class CreditAccount extends Account {
	private double ceiling; // 透支额度

	public double getCeiling() {
		return ceiling;
	}

	public void setCeiling(double ceiling) {
		this.ceiling = ceiling;
	}

	@Override
	public boolean withdraw(double money) {
		/*
		 * 取款的金额<=账户余额+透支额度
		 * 
		 * 假设：余额5000 可透支额度10000
		 * 
		 * 支取的金额：3000
		 * 
		 * 剩余：余额：2000 可透支额度10000
		 * 
		 * 支取的金额：5000
		 * 
		 * 剩余：余额：-3000 可透支额度10000
		 */
		if (getBalance() + ceiling >= money) {
			setBalance(getBalance() - money);
			return true;
		}
		return false;
	}

}
