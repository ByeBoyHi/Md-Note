package com.itany.shopping.view;

import java.util.Scanner;

import com.itany.shopping.constant.PaginationConstant;
import com.itany.shopping.entity.Product;
import com.itany.shopping.entity.User;
import com.itany.shopping.exception.UserDisabledException;
import com.itany.shopping.exception.UserNotFoundException;
import com.itany.shopping.exception.UsernameExistException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ProductService;
import com.itany.shopping.service.UserService;
import com.itany.shopping.vo.PageResult;

public class Start {
	Scanner input = new Scanner(System.in);
	
	private ProductService productService=(ProductService) ObjectFactory.getObject("productServiceProxy");
	private UserService userService=(UserService) ObjectFactory.getObject("userServiceProxy");
	
	/*
	 * 显示系统菜单
	 */
	public void showSystemMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1.登陆\t\t2.注册\t\t3.查看商品列表");
		System.out.println("------------------------------------------------");
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch(choice){
			case 1:
				login();
				break;
			case 2:
				regist();
				break;
			case 3:
				showProductList();
				break;
			default:
				System.out.println("输入有误");
				break;
		}
	}

	private void login() {
		User user = new User();
		System.out.print("请输入用户名：");
		user.setUsername(input.next());
		System.out.print("请输入密码：");
		user.setPassword(input.next());
		try {
			User u = userService.login(user);
			System.out.println("登陆成功，欢迎您："+u.getUsername());
			new UserView(u).showMenu(); // 显示用户菜单
		} catch (UserNotFoundException | UserDisabledException e) {
			System.out.println("登陆失败："+e.getMessage());
			showSystemMenu(); // 返回系统主菜单
		}
		
	}

	private void regist() {
		User user = new User();
		System.out.print("请输入用户名：");
		user.setUsername(input.next());
		while(true){
			System.out.print("请输入密码：");
			user.setPassword(input.next());
			System.out.print("请输入确认密码：");
			String repassword = input.next();
			if(repassword.equals(user.getPassword())){
				break;
			}
			System.out.println("提示：两次输入的密码不一致，请重新输入");
		}
		System.out.print("请输入电话：");
		user.setPhone(input.next());
		System.out.print("请输入地址：");
		user.setAddress(input.next());
		
		try {
			userService.regist(user);
			System.out.println("注册成功");
		} catch (UsernameExistException e) {
			System.out.println("注册失败："+e.getMessage());
		}
		showSystemMenu(); //返回系统菜单
	}
	
	/*
	 * 显示商品列表
	 */
	private void showProductList() {
		System.out.println("------------------------------------------------");
		// List<Product> products = productService.findAll();
		 PageResult<Product> pageResult = productService.findByPage(2, PaginationConstant.PAGE_SIZE);
		System.out.println("编号\t商品\t价格");
		for (Product product : pageResult.getList()) {
			System.out.println(product.getId()+"\t"+product.getName()+"\t"+product.getPrice());
		}
		System.out.println("上一页："+pageResult.getPrePage()+"\t当前页："+pageResult.getPageNo()+"\t下一页："+pageResult.getNextPage());
		System.out.println("总页数："+pageResult.getPages());
		
		showSystemMenu(); //返回系统菜单
	}
	
	public static void main(String[] args) {
		System.out.println("############################欢迎使用购物系统############################");
		new Start().showSystemMenu();
	}
	
}
