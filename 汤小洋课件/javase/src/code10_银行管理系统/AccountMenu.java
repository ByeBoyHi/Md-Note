package code10_银行管理系统;

import java.util.Scanner;

/*
 * 账户菜单类
 */
public class AccountMenu {
	private Scanner input = new Scanner(System.in);
	private Account account; // 当前登陆的账户

	public AccountMenu() {
	}

	public AccountMenu(Account account) {
		this.account = account;
	}

	// 显示账户主菜单
	public void showMainMenu() {
		System.out.println("----------------------------------");
		System.out.println("1.存款 2.取款 3.查询余额 4.转账 5.贷款 6.还贷 7.修改密码 8.注销");
		System.out.println("----------------------------------");
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			// 存款
			deposit();
			break;
		case 2:
			// 取款
			withdraw();
			break;
		case 3:
			// 查询余额
			queryBalance();
			break;
		case 4:
			// 转账
			transfer();
			break;
		case 5:
			// 贷款
			requestLoan();
			break;
		case 6:
			// 还贷
			payLoan();
			break;
		case 7:
			// 修改密码
			modifyPassword();
			break;
		case 8:
			// 注销
			logout();
			break;
		}
	}

	// 修改密码
	private void modifyPassword() {
		System.out.println("----------------------------------");
		System.out.print("请输入原密码：");
		String oldPassword = input.next();
		System.out.print("请输入新密码：");
		String newPassword = input.next();
		System.out.print("请再次输入新密码：");
		String rePassword = input.next();
		// 判断原密码是否正确
		if (!oldPassword.equals(account.getPassword())) {
			System.out.println("提示：原密码错误！");
		} else {
			// 判断两次输入的新密码是否一致
			if (!rePassword.equals(newPassword)) {
				System.out.println("提示：两次输入的密码不一致！");
			} else {
				account.setPassword(newPassword);
				System.out.println("提示：修改成功，请重新登陆！");
				new Start().showSystemMenu(); // 返回系统主菜单
			}
		}
		showMainMenu();
	}

	// 还贷
	private void payLoan() {
		System.out.println("----------------------------------");
		// 判断是否为可贷款账户
		if (account instanceof Loanable) {
			System.out.print("请输入还款金额：");
			int money = input.nextInt();
			Loanable loan = (Loanable) account;
			if (loan.payLoan(money)) {
				System.out.println("提示：还贷成功，余额为：" + account.getBalance()
						+ "，贷款总额为：" + loan.getLoan());
			} else {
				System.out.println("提示：还贷失败！");
			}
		} else {
			System.out.println("提示：此账户非贷款银行卡！");
		}
		showMainMenu();
	}

	// 贷款
	private void requestLoan() {
		System.out.println("----------------------------------");
		// 判断是否为可贷款账户
		if (account instanceof Loanable) {
			System.out.print("请输入贷款金额：");
			int money = input.nextInt();
			Loanable loan = (Loanable) account;
			if (loan.requestLoan(money)) {
				System.out.println("提示：贷款成功，您当前的贷款总额为：" + loan.getLoan());
			} else {
				System.out.println("提示：贷款失败！");
			}
		} else {
			System.out.println("提示：此账户非贷款银行卡！");
		}
		showMainMenu();
	}

	// 转账
	private void transfer() {
		System.out.println("----------------------------------");
		System.out.print("请输入要转入的目标账户号：");
		int id = input.nextInt();
		System.out.print("请输入转账金额：");
		int money = input.nextInt();
		Account destAccount = Bank.findById(id);
		if (destAccount == null) {
			System.out.println("提示：目标账户不存在！");
		} else {
			if (account.getBalance() < money) {
				System.out.println("提示：您的账户余额不足，余额为：" + account.getBalance());
			} else {
				account.setBalance(account.getBalance() - money);
				destAccount.setBalance(destAccount.getBalance() + money);
				System.out.println("提示：转账成功，余额为：" + account.getBalance());
			}
		}
		showMainMenu();
	}

	// 查询余额
	private void queryBalance() {
		System.out.println("----------------------------------");
		System.out.println("您的余额：" + account.getBalance() + "元！");
		showMainMenu();
	}

	// 取款
	private void withdraw() {
		System.out.println("----------------------------------");
		System.out.print("请输入取款金额：");
		int money = input.nextInt();
		if (account.withdraw(money)) {
			System.out.println("提示：取款成功！");
		} else {
			System.out.println("提示：取款失败，余额不足！");
		}
		showMainMenu();
	}

	// 注销
	private void logout() {
		System.out.println("提示：注销成功！");
		new Start().showSystemMenu();
	}

	// 存款
	private void deposit() {
		System.out.println("----------------------------------");
		System.out.print("请输入存款金额：");
		int money = input.nextInt();
		account.deposit(money);
		System.out.println("提示：存款成功！");
		showMainMenu(); // 返回账户主菜单
	}
}
