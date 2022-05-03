package com.itany.sms.view;

import java.util.List;
import java.util.Scanner;

import com.itany.sms.dao.ClazzDao;
import com.itany.sms.dao.impl.ClazzDaoImpl;
import com.itany.sms.entity.Clazz;
import com.itany.sms.exception.ClazzException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.ClazzService;

public class ClazzView {
	Scanner input = new Scanner(System.in);
	ClazzService clazzService=(ClazzService) ObjectFactory.getObject("clazzServiceProxy");

	public void showMenu(){
		System.out.println("1.查询所有班级");
		System.out.println("2.根据班级号查询班级");
		System.out.println("3.添加班级");
		System.out.println("4.删除班级");
		
		System.out.print("请选择：");
		int choice = input.nextInt();
		switch(choice){
			case 1:
				findAll();
				break;
			case 2:
				findById();
				break;
			case 3:
				add();
				break;
			case 4:
				removeById();
				break;
		}
		showMenu();
	}

	private void removeById() {
		System.out.print("请输入班级号：");
		try {
			clazzService.removeById(input.nextInt());
			System.out.println("删除成功");
		} catch (ClazzException e) {
			System.out.println("删除失败："+e.getMessage());
		}
	}

	private void findAll() {
		List<Clazz> list = clazzService.findAll();
		System.out.println(list);
	}

	private void findById() {
		System.out.print("请输入班级号：");
		Clazz clazz = clazzService.findById(input.nextInt());
		System.out.println(clazz);
	}

	private void add() {
		System.out.print("请输入班级名称：");
		clazzService.add(input.next());
		System.out.println("添加成功");
	}
}
