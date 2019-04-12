package com.test.service;

import java.sql.SQLException;
import java.util.List;

import com.test.domain.PageBean;
import com.test.domain.Student;

public interface StudentService {
	List<Student> findAll() throws SQLException;

	void insert(Student student) throws SQLException;

	void delete(int sid) throws SQLException;

	Student findStudentById(int sid) throws SQLException;

	void update(Student stu) throws SQLException;

	List<Student> searchStudent(String sname, String sgender) throws SQLException;

	PageBean findStudentByPage(int currentPage) throws SQLException;
}
