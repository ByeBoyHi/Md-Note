create table t_dept
(
	id int auto_increment primary key,
	dname varchar(30) unique not null,
	location varchar(50)
);

create table t_emp
(
	empno int auto_increment primary key,
	ename varchar(50) not null,
	salary double,
	hiredate date,
	dept_id int,
	foreign key (dept_id) references t_dept(id)
);

功能：
员工管理
1.查询所有员工
2.根据编号查询员工
3.查询入职时间的范围查询员工
4.添加员工
5.根据编号删除员工
6.修改员工
7.根据部门名查询员工
8.对调两员员工所在部门

部门管理
1.查询所有部门
2.根据部门编号查询部门
3.添加部门
4.修改部门
5.删除部门



