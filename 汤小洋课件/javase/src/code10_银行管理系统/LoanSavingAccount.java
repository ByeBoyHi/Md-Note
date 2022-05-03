package code10_银行管理系统;

/*
 * 贷款的储蓄账户类
 */
public class LoanSavingAccount extends SavingAccount implements Loanable {

	private double loanAmount; // 贷款总额

	@Override
	public boolean requestLoan(double money) {
		this.loanAmount += money;
		return true;
	}

	@Override
	public boolean payLoan(double money) {
		// 判断余额大于还贷金额
		if (getBalance() >= money) {
			setBalance(getBalance() - money);
			loanAmount -= money;
			return true;
		}
		return false;
	}

	@Override
	public double getLoan() {
		return this.loanAmount;
	}

}
