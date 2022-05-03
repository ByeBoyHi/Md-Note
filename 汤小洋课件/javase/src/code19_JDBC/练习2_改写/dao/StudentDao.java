package code19_JDBC.练习2_改写.dao;

import java.util.List;

import code19_JDBC.练习2_改写.entity.Student;
import code19_JDBC.练习2_改写.mapper.StudentMapper;
import code19_JDBC.练习2_改写.util.JdbcTemplate;
import code19_JDBC.练习2_改写.util.RowMapper;

public class StudentDao {
	
	JdbcTemplate<Student> template=new JdbcTemplate<>();
    RowMapper<Student> rm = new StudentMapper();
	
	// 1.查询所有学生
	public List<Student> selectAll(){
 		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
			.append(" from ")
			.append(" 	t_student s,t_class c")
			.append(" where ")
			.append(" 	s.cid=c.id ")
			.toString();
 		return template.query(sql, rm);
	}
	
	// 2.根据学号查询学生
	public Student selectById(int id){
 		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
			.append(" from ")
			.append(" 	t_student s,t_class c")
			.append(" where ")
			.append(" 	s.cid=c.id and s.id=?")
			.toString();
		List<Student> list = template.query(sql, rm,id);
		return list.isEmpty()?null:list.get(0);
	}

	// 3.根据姓名和年龄范围查询学生
	public List<Student> selectByCondition(String name,int minAge,int maxAge){
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
		.append(" from ")
		.append(" 	t_student s,t_class c")
		.append(" where ")
		.append(" 	s.cid=c.id and s.name like ? and s.age between ? and ?")
		.toString();
		return template.query(sql, rm, "%"+name+"%",minAge,maxAge);
	}
	
	// 4.添加学生
	public void insert(Student stu){
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
	public void update(Student stu){
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
	public void deleteById(int id){
		String sql=new StringBuffer()
			.append(" delete from ")
			.append(" 	t_student ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, id);
	}
}
