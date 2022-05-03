package code09_抽象类和接口;

import java.util.Scanner;

/*
 * 提示用户输入状态，然后根据状态进行判断并提示
 * 
 * 定义常量表示用户的状态
 */
public class 练习1_常量 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("请输入您的状态：");
		int status = input.nextInt();
		if(status==UserConstant.STATUS_ENABLE){
			System.out.println("启用");
		}else if(status==UserConstant.STATUS_NO_PERMISSION){
			System.out.println("没有权限");
		}else if(status==UserConstant.STATUS_TIMEOUT){
			System.out.println("过期");
		}else if(status==UserConstant.STATUS_DISABLE){
			System.out.println("禁用");
		}
	}
}

class UserConstant{
	/*
	 * 用户状态，0表示禁用
	 */
	public static final int STATUS_DISABLE=0;
	
	/*
	 * 用户状态，1表示启用
	 */
	public static final int STATUS_ENABLE=1;
	
	/*
	 * 用户状态，2表示没有权限
	 */
	public static final int STATUS_NO_PERMISSION=2;
	
	/*
	 * 用户状态，3表示过期
	 */
	public static final int STATUS_TIMEOUT=3;
			
	
	
	
	
}
