package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.domain.Student;

public interface StudentDao {
	int PAGE_SIZE=5;
	List<Student> findAll() throws SQLException;//抛出的异常由实现类决定

	void insert(Student student) throws SQLException;

	void delete(int sid) throws SQLException;

	Student findStudentById(int sid) throws SQLException;

	void update(Student stu) throws SQLException;

	List<Student> findStudentByPage(int currentPage) throws SQLException;

	int findCount() throws SQLException;
}
