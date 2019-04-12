package com.test.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.test.dao.StudentDao;
import com.test.dao.impl.StudentDaoImpl;
import com.test.domain.PageBean;
import com.test.domain.Student;
import com.test.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao stu=new StudentDaoImpl();
		return stu.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.insert(student);
	}
	
	@Override
	public void delete(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.delete(sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		return dao.findStudentById(sid);
	}

	@Override
	public void update(Student stu) throws SQLException {
		StudentDao dao=new StudentDaoImpl();
		dao.update(stu);
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		return new StudentDaoImpl().searchStudent(sname,sgender);
		
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//封装当前页的学生集合
		PageBean<Student> pageBean=new PageBean<Student>();
		int pageSize=StudentDao.PAGE_SIZE;
		pageBean.setCurrentPage(currentPage);//当前页
		pageBean.setPageSize(pageSize);//每页显示记录数
		StudentDao dao=new StudentDaoImpl();
		List<Student> list=dao.findStudentByPage(currentPage);
		pageBean.setList(list);
		
		int count=dao.findCount();
		pageBean.setTotalSize(count);
		pageBean.setTotalPage(count%pageSize==0?count/pageSize:(count/pageSize)+1);
		return pageBean;
	}
}
