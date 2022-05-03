package code19_JDBC.练习2_改写.view;

import java.util.List;
import java.util.Scanner;

import code19_JDBC.练习2_改写.dao.ClazzDao;
import code19_JDBC.练习2_改写.entity.Clazz;

/*
 * 1.查询所有班级
	2.根据班级号查询班级
	3.添加班级
 */
public class ClazzView {
	Scanner input = new Scanner(System.in);
	ClazzDao clazzDao=new ClazzDao();

	public void showMenu(){
		System.out.println("1.查询所有班级");
		System.out.println("2.根据班级号查询班级");
		System.out.println("3.添加班级");
		
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
		}
		showMenu();
	}

	private void findAll() {
		List<Clazz> list = clazzDao.selectAll();
		System.out.println(list);
	}

	private void findById() {
		System.out.print("请输入班级号：");
		Clazz clazz = clazzDao.selectById(input.nextInt());
		System.out.println(clazz);
	}

	private void add() {
		System.out.print("请输入班级名称：");
		clazzDao.insert(input.next());
		System.out.println("添加成功");
	}
}
