package com.test.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.domain.Student;
import com.test.service.StudentService;
import com.test.service.impl.StudentServiceImpl;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收id
		int sid=Integer.parseInt(request.getParameter("sid"));
		System.out.println(sid);
		StudentService service=new StudentServiceImpl();
		try {
			Student stu=null;
			stu = service.findStudentById(sid);
			request.setAttribute("stu", stu);
//			System.out.println(stu);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
