package com.itany.sms.dao.impl;

import java.util.List;

import com.itany.sms.dao.StudentDao;
import com.itany.sms.entity.Student;
import com.itany.sms.mapper.StudentMapper;
import com.itany.sms.util.JdbcTemplate;
import com.itany.sms.util.RowMapper;

public class StudentDaoImpl implements StudentDao {
	
	JdbcTemplate<Student> template=new JdbcTemplate<>();
    RowMapper<Student> rm = new StudentMapper();
	
	// 1.查询所有学生
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public void deleteById(int id){
		String sql=new StringBuffer()
			.append(" delete from ")
			.append(" 	t_student ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, id);
	}

	@Override
	public void updateClazzId(int sid, int cid) {
		String sql=new StringBuffer()
			.append(" update ")
			.append(" 	t_student ")
			.append(" set ")
			.append(" 	cid=? ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		template.update(sql, cid,sid);
	}

	@Override
	public Student selectByName(String name) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
		.append(" from ")
		.append(" 	t_student s,t_class c")
		.append(" where ")
		.append(" 	s.cid=c.id and s.name=?")
		.toString();
	return template.queryForObject(sql, rm, name);
	}

	@Override
	public List<Student> selectByCid(int id) {
		String sql=new StringBuffer()
		.append(" select ")
		.append(" 	s.id,s.name,s.age,s.height,s.birthday,c.id cid,c.name cname ")
		.append(" from ")
		.append(" 	t_student s,t_class c")
		.append(" where ")
		.append(" 	s.cid=c.id and c.id=?")
		.toString();
		return template.query(sql, rm, id);
	}
}
