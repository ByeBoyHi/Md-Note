package code10_银行管理系统;

/*
 * 贷款接口
 */
public interface Loanable {

	// 贷款
	boolean requestLoan(double money);

	// 还贷
	boolean payLoan(double money);

	// 获取贷款总额
	double getLoan();
}
