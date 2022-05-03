package code19_JDBC.练习1_学生管理系统;

import java.util.Date;
import java.util.List;

public class Test {
	
	static StudentTemplate template=new StudentTemplate();
	
	public static void main(String[] args) {
//		System.out.println(selectAll());
//		System.out.println(selectById(2));
//		System.out.println(selectByCondition("小", 10, 19));
		
		Student stu = new Student();
		stu.setId(1);
		stu.setName("bbb");
		stu.setAge(28);
		stu.setHeight(170.5);
		stu.setBithday(new Date());
		Clazz clazz = new Clazz();
		clazz.setId(1);
		stu.setClazz(clazz);
//		update(stu);
		
		deleteById(1);
		
		System.out.println("success");
	}
	
	// 1.查询所有学生
	public static List<Student> selectAll(){
 		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
			.append(" from ")
			.append(" 	t_student s,t_class c")
			.append(" where ")
			.append(" 	s.cid=c.id ")
			.toString();
 		return template.query(sql);
	}
	
	// 2.根据学号查询学生
	public static Student selectById(int id){
 		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
			.append(" from ")
			.append(" 	t_student s,t_class c")
			.append(" where ")
			.append(" 	s.cid=c.id and s.id=?")
			.toString();
		List<Student> list = template.query(sql, id);
		return list.isEmpty()?null:list.get(0);
	}

	// 3.根据姓名和年龄范围查询学生
	public static List<Student> selectByCondition(String name,int minAge,int maxAge){
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
		.append(" from ")
		.append(" 	t_student s,t_class c")
		.append(" where ")
		.append(" 	s.cid=c.id and s.name like ? and s.age between ? and ?")
		.toString();
		return template.query(sql, "%"+name+"%",minAge,maxAge);
	}
	
	// 4.添加学生
	public static void insert(Student stu){
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_student ")
			.append(" 		(name,age,height,birthday,cid) ")
			.append(" values ")
			.append("  		(?,?,?,?,?) ")
			.toString();
		template.update(sql, stu.getName(),stu.getAge(),stu.getHeight(),stu.getBithday(),stu.getClazz().getId());
	}
	
	// 5.修改学生
	public static void update(Student stu){
		String sql=new StringBuffer()
			.append(" update ")
			.append(" 	t_student ")
			.append(" set ")
			.append("  	name=?,age=?,height=?,birthday=?")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, stu.getName(),stu.getAge(),stu.getHeight(),stu.getBithday(),stu.getId());
	}
	
	// 6.根据学号删除学生
	public static void deleteById(int id){
		String sql=new StringBuffer()
			.append(" delete from ")
			.append(" 	t_student ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, id);
	}
	
}
