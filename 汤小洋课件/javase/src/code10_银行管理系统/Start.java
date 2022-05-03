package code10_银行管理系统;

import java.util.Scanner;

/**
 * 银行管理系统，启动类
 * 
 * @author 汤小洋
 * @date 2019-2-14 12:30:40
 * @version v1.0
 */
public class Start {
	private Scanner input = new Scanner(System.in);
	
	/**
	 * 
	 * @param args 命令行参数
	 * @return 个数
	 * @date 2019-2-14 12:35:31
	 */
	public static void main(String[] args) {
		System.out
				.println("******************欢迎使用银行管理系统**********************");
		new Start().showSystemMenu();
	}

	// 显示系统主菜单
	public void showSystemMenu() {
		System.out.println("----------------------------------");
		System.out.println("1.开户\t\t2.登陆");
		System.out.println("----------------------------------");
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			register();
			break;
		case 2:
			login();
			break;
		default:
			System.out.println("输入有误！");
			break;
		}

	}

	// 登陆
	private void login() {
		System.out.print("请输入账户号：");
		int id = input.nextInt();
		System.out.print("请输入密码：");
		String password = input.next();

		Account account = Bank.login(id, password);
		if (account != null) {
			System.out.println("----------------------------------");
			System.out.println("欢迎您：" + account.getName());
			new AccountMenu(account).showMainMenu(); // 显示账户主菜单

		} else {
			System.out.println("提示：账户号或密码不正确！");
			showSystemMenu(); // 返回系统主菜单
		}

	}

	// 开户
	private void register() {
		System.out.print("请选择要办理的账户种类(1.储蓄账户 2.信用账户 3.贷款的储蓄账户 4.贷款的信用账户)：");
		int num = input.nextInt();
		Account account = null;
		switch (num) {
		case 1:
			account = new SavingAccount();
			break;
		case 2:
			account = new CreditAccount();
			break;
		case 3:
			account = new LoanSavingAccount();
			break;
		case 4:
			account = new LoanCreditAccount();
			break;
		}
		System.out.print("请输入姓名：");
		account.setName(input.next());
		while (true) {
			System.out.print("请输入密码：");
			String password = input.next();
			System.out.print("请输入确认密码：");
			String rePassword = input.next();
			if (rePassword.equals(password)) {
				account.setPassword(password);
				break;
			} else {
				System.out.println("提示：两次输入的密码不一致，请重新输入！");
			}
		}
		System.out.print("请输入身份证：");
		account.setPersonID(input.next());
		System.out.print("请输入邮箱：");
		account.setEmail(input.next());
		// 判断是否为信用账户
		if (account instanceof CreditAccount) {
			System.out.print("请输入申请的透支额度：");
			CreditAccount creditAccount = (CreditAccount) account;
			creditAccount.setCeiling(input.nextDouble());
		}

		if (Bank.register(account)) {
			System.out.println("提示：开户成功，账户号为：" + account.getId());
		} else {
			System.out.println("提示：开户失败！");
		}
		showSystemMenu(); // 返回系统主菜单
	}

}
