package com.itany.shopping.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.itany.shopping.entity.Item;
import com.itany.shopping.entity.Order;
import com.itany.shopping.entity.Product;
import com.itany.shopping.entity.User;
import com.itany.shopping.exception.ProductNotFoundException;
import com.itany.shopping.factory.ObjectFactory;
import com.itany.shopping.service.ItemService;
import com.itany.shopping.service.OrderService;
import com.itany.shopping.service.ProductService;
import com.itany.shopping.service.UserService;
import com.itany.shopping.util.EncryptUtil;
import com.itany.shopping.util.StringUtil;
import com.itany.shopping.vo.Cart;

public class UserView {

	Scanner input = new Scanner(System.in);
	private Cart cart = new Cart(); // 当前用户的购物车
	private User user; // 当前登陆的用户

	private ProductService productService = (ProductService) ObjectFactory
			.getObject("productServiceProxy");
	private OrderService orderService=(OrderService) ObjectFactory.getObject("orderServiceProxy");
	private ItemService itemService=(ItemService) ObjectFactory.getObject("itemServiceProxy");
	private UserService userService=(UserService) ObjectFactory.getObject("userServiceProxy");

	public UserView(User user) {
		this.user = user;
	}

	/*
	 * 显示用户主菜单
	 */
	public void showMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1.购买商品    2.查看购物车    3.我的订单    4.修改密码    5.注销");
		System.out.println("------------------------------------------------");
		System.out.print("请选择：");

		int choice = input.nextInt();
		switch (choice) {
		case 1:
			buy();
			break;
		case 2:
			showCart();
			break;
		case 3:
			showMyOrder();
			break;
		case 4:
			modifyPwd();
			break;
		case 5:
			logout();
			break;
		default:
			System.out.println("输入有误");
			break;
		}
	}

	/*
	 * 购买商品
	 */
	private void buy() {
		System.out.println("------------------------------------------------");
		List<Product> products = productService.findAll();
		System.out.println("编号\t商品\t价格");
		for (Product product : products) {
			System.out.println(product.getId() + "\t" + product.getName()
					+ "\t" + product.getPrice());
		}
		System.out.print("请选择要添加到购物车的商品编号：");
		int id = input.nextInt();
		try {
			cart.add(id);
			System.out.println("添加成功");
		} catch (ProductNotFoundException e) {
			System.out.println("添加失败：" + e.getMessage());
		}
		showMenu(); // 返回用户主菜单
	}

	/*
	 * 显示购物车
	 */
	private void showCart() {
		System.out.println("------------------------------------------------");
		System.out.println("编号\t商品\t单价\t数量\t金额");
		double totalPrice = 0.0;
		for (Item item : cart.getItems()) {
			System.out.println(item.getProduct().getId() + "\t"
					+ item.getProduct().getName() + "\t"
					+ item.getProduct().getPrice() + "\t" + item.getNum()
					+ "\t" + Math.round(item.getPrice() * 100) / 100.0);
			totalPrice += item.getPrice();
		}
		System.out.println("------------------------------------------------");
		System.out.println("共：" + cart.getItems().size() + "件，总计：" + totalPrice
				+ "元");
		System.out.println("------------------------------------------------");
		System.out.print("请选择（1.删除商品  2.修改商品数量  3.清空购物车  4.结算  5.返回用户主菜单）：");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			// 删除商品
			removeFromCart();
			break;
		case 2:
			// 修改商品数量
			modifyNum();
			break;
		case 3:
			// 清空购物车
			clearCart();
			break;
		case 4:
			// 结算
			settleAccount();
			break;
		case 5:
			// 5.返回用户主菜单
			showMenu();
			break;
		}
		showCart();
	}

	/*
	 * 从购物车中删除商品
	 */
	private void removeFromCart() {
		System.out.println("------------------------------------------------");
		System.out.print("请输入要删除的商品编号：");
		cart.removeById(input.nextInt());
		System.out.println("删除成功");
	}

	/*
	 * 修改购物车中商品的数量
	 */
	private void modifyNum() {
		System.out.println("------------------------------------------------");
		System.out.print("请输入要修改的商品编号：");
		int id = input.nextInt();
		System.out.print("请输入商品数量：");
		int num = input.nextInt();
		cart.modifyNum(id, num);
		System.out.println("修改商品数量成功");
	}

	/*
	 * 清空购物车
	 */
	private void clearCart() {
		cart.clear();
		System.out.println("购物车已清空");
	}

	/*
	 * 结算
	 */
	private void settleAccount() {
		System.out.println("------------------------------------------------");
		System.out.println("订单信息如下：");
		System.out.println("用户：" + user.getUsername() + "，电话："
				+ user.getPhone() + "，地址：" + user.getAddress());
		System.out.println("------------------------------------------------");
		System.out.println("编号\t商品\t单价\t数量\t金额");
		double totalPrice = 0.0;
		for (Item item : cart.getItems()) {
			System.out.println(item.getProduct().getId() + "\t"
					+ item.getProduct().getName() + "\t"
					+ item.getProduct().getPrice() + "\t" + item.getNum()
					+ "\t" + Math.round(item.getPrice() * 100) / 100.0);
			totalPrice += item.getPrice();
		}
		System.out.println("------------------------------------------------");
		System.out.println("共：" + cart.getItems().size() + "件，总计：" + totalPrice
				+ "元");
		System.out.print("确认要提交订单吗？（1.确认   2.返回）");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			submitOrder();
			break;
		case 2:
			showCart();
			break;
		default:
			System.out.println("输入有误");
			break;
		}
	}

	/*
	 * 提交订单
	 */
	private void submitOrder() {
		Order order = new Order();
		order.setUser(user);
		order.setNo(StringUtil.generateNo());
		double totalPrice = 0.0;
		for (Item item : cart.getItems()) {
			totalPrice += item.getPrice();
		}
		order.setPrice(totalPrice);
		order.setCreateDate(new Date());
		order.setItems(new HashSet<Item>(cart.getItems()));

		orderService.add(order);
		System.out.println("订单生成成功，订单号：" + order.getNo());
		cart.clear(); // 清空购物车
		showMenu(); // 返回用户主菜单
	}

	/*
	 * 我的订单
	 */
	private void showMyOrder() {
		System.out.println("------------------------------------------------");
		System.out.println("用户：" + user.getUsername() + "，您的订单如下：");
		System.out.println("编号\t\t订单号\t\t订单时间");
		List<Order> orders = orderService.findByUserId(user.getId());
		for (Order order : orders) {
			System.out.println(order.getId()
					+ "\t"
					+ order.getNo()
					+ "\t"
					+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order
							.getCreateDate()));
		}
		System.out.println("------------------------------------------------");
		System.out.print("请输入要查看的订单编号：");
		int orderId = input.nextInt();
		
		Order order = orderService.findById(orderId,user.getId());
		if(order==null){
			System.out.println("该订单不存在");
		}else{
			List<Item> items = itemService.findByOrderId(orderId,user.getId());
			System.out.println("------------------------------------------------");
			System.out.println("该订单的明细如下：");
			System.out.println("订单号："+order.getNo()+"，订单时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getCreateDate()));
			System.out.println("------------------------------------------------");
			System.out.println("编号\t商品\t单价\t数量\t金额");
			double totalPrice = 0.0;
			for (Item item : items) {
				System.out.println(item.getProduct().getId() + "\t"
						+ item.getProduct().getName() + "\t"
						+ item.getProduct().getPrice() + "\t" + item.getNum()
						+ "\t" + Math.round(item.getPrice() * 100) / 100.0);
				totalPrice += item.getPrice();
			}
			System.out.println("------------------------------------------------");
			System.out.println("共：" + items.size() + "件，总计：" + totalPrice
					+ "元");
		}
		showMenu(); // 返回用户主菜单
	}

	/*
	 * 修改密码
	 */
	private void modifyPwd() {
		System.out.println("------------------------------------------------");
		System.out.print("请输入原密码：");
		String oldPassword = input.next();
		System.out.print("请输入新密码：");
		String newPassword = input.next();
		System.out.print("请再次输入新密码：");
		String rePassword = input.next();
		// 判断原密码是否正确
		if(!EncryptUtil.md5(oldPassword).equals(user.getPassword())){
			System.out.println("原密码不正确");
			modifyPwd(); // 重新输入
		}else{
			if(!rePassword.equals(newPassword)){
				System.out.println("两次输入的密码不一致");
				modifyPwd(); // 重新输入
			}else{
				userService.modifyPassword(user.getId(),newPassword);
				System.out.println("密码修改成功");
				new Start().showSystemMenu(); // 返回系统菜单
			}
		}
		
	}

	private void logout() {
		new Start().showSystemMenu();  // 返回系统菜单
	}

	public static void main(String[] args) {
		// new UserView().showMenu();
	}

}
