package com.itany.sms.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.itany.sms.dao.StudentDao;
import com.itany.sms.dao.impl.StudentDaoImpl;
import com.itany.sms.entity.Clazz;
import com.itany.sms.entity.Student;
import com.itany.sms.exception.StudentNotFoundException;
import com.itany.sms.exception.UsernameExistException;
import com.itany.sms.factory.ObjectFactory;
import com.itany.sms.service.StudentService;

public class StudentView {

	Scanner input = new Scanner(System.in);
	StudentService studentService=(StudentService) ObjectFactory.getObject("studentServiceProxy");

	public void showMenu() {
		System.out.println("1.查询所有学生");
		System.out.println("2.根据学号查询学生");
		System.out.println("3.根据姓名和年龄范围查询学生");
		System.out.println("4.添加学生");
		System.out.println("5.修改学生");
		System.out.println("6.根据学号删除学生");
		System.out.println("7.调换两名学生所在班级");
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
				findByCondition();
				break;
			case 4:
				add();
				break;
			case 5:
				modify();
				break;
			case 6:
				removeById();
				break;
			case 7:
				swap();
				break;
		}
		showMenu(); //重复执行
	}

	private void swap() {
		System.out.print("请输入第一位学生的姓名:");
		String name1 = input.next();
		System.out.print("请输入第二位学生的姓名:");
		String name2 = input.next();
		try {
			studentService.swap(name1, name2);
			System.out.println("调换成功");
		} catch (StudentNotFoundException e) {
			System.out.println("调换失败："+e.getMessage());
		}
	}

	private void findAll() {
		List<Student> list = studentService.findAll();
		System.out.println(list);
	}

	private void findById() {
		System.out.print("请输入学号：");
		Student student = studentService.findById(input.nextInt());
		System.out.println(student);
	}

	private void findByCondition() {
		System.out.print("请输入姓名：");
		String name=input.next();
		System.out.print("请输入最小年龄：");
		int minAge = input.nextInt();
		System.out.print("请输入最大年龄：");
		int maxAge = input.nextInt();
		List<Student> list = studentService.findByCondition(name, minAge, maxAge);
		System.out.println(list);
	}

	private void add() {
		Student stu = new Student();
		System.out.print("请输入姓名：");
		stu.setName(input.next());
		System.out.print("请输入年龄：");
		stu.setAge(input.nextInt());
		System.out.print("请输入身高：");
		stu.setHeight(input.nextDouble());
		System.out.print("请输入出生日期：");
		try {
			stu.setBithday(new SimpleDateFormat("yyyy-MM-dd").parse(input.next()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("请输入班级号：");
		Clazz clazz = new Clazz();
		clazz.setId(input.nextInt());
		stu.setClazz(clazz);
		
		try {
			studentService.add(stu);
			System.out.println("添加成功");
		} catch (UsernameExistException e) {
			System.out.println("添加失败："+e.getMessage());
		}
	}

	private void modify() {
		
	}

	private void removeById() {
		
	}
}
