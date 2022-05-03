package code19_JDBC.练习2_改写.dao;

import java.util.List;

import code19_JDBC.练习2_改写.entity.Clazz;
import code19_JDBC.练习2_改写.mapper.ClazzMapper;
import code19_JDBC.练习2_改写.util.JdbcTemplate;
import code19_JDBC.练习2_改写.util.RowMapper;


public class ClazzDao {
	
	JdbcTemplate<Clazz> template=new JdbcTemplate<Clazz>();
	RowMapper<Clazz> rm=new ClazzMapper();
	

	//1.查询所有班级
	public List<Clazz> selectAll(){
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,name ")
			.append(" from ")
			.append(" 	t_class ")
			.toString();
		return template.query(sql, rm);
	}
	
	//2.根据班级号查询班级
	public Clazz selectById(int id){
		String sql=new StringBuffer()
			.append(" select ")
			.append(" 	id,name ")
			.append(" from ")
			.append(" 	t_class ")
			.append(" where ")
			.append(" 	id=? ")
			.toString();
		return template.queryForObject(sql, rm, id);
	}
	
	
	//3.添加班级
	public void insert(String name){
		String sql=new StringBuffer()
			.append(" insert into ")
			.append(" 	t_class ")
			.append(" 		(name) ")
			.append(" values ")
			.append(" 		(?) ")
			.toString();
		template.update(sql, name);
	}
	
}
