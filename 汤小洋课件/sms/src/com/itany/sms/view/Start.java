package com.itany.sms.view;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		new Start().showSystemMenu();
	}
	
	// 显示系统菜单
	public void showSystemMenu(){
		System.out.println("=================欢迎使用学生管理系统=======================");
		System.out.println("1.学生管理   2.班级管理");
		System.out.print("请选择：");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if(choice==1){
			new StudentView().showMenu();
		}else if(choice==2){
			new ClazzView().showMenu();
		}
	}
	

}
