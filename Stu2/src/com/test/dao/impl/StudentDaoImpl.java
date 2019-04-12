package com.test.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.test.dao.StudentDao;
import com.test.domain.Student;
import com.test.util.JDBCUtil02;
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo());
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from stu where sid=?",sid);//prepareStatement
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class),sid);//返回Student对象，用BeanHandler封装？
		
	}

	@Override
	public void update(Student stu) throws SQLException {
		QueryRunner runner =new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
				stu.getSname(),
				stu.getGender(),
				stu.getPhone(),
				stu.getBirthday(),
				stu.getHobby(),
				stu.getInfo(),
				stu.getSid());
		System.out.println("update");
	}

	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		String sql="select * from stu where 1=1";//默认全部
		String str="";
		if(sname!=null&&sname.length()!=0) {
			sql=sql+" and sname like ?";
			str+="%"+sname+"%";
		}
		if(sgender!=null&&sgender.length()!=0) {
			sql=sql+" and sgender= ?";
			str+=sgender;
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class),str);
	}
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
		
	}
	public int findCount() throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());
		Long result=(Long) runner.query("select count(*) from stu",new ScalarHandler());
		return result.intValue();
	}
}
