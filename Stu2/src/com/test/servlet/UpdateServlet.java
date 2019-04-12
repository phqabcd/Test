package com.test.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.domain.Student;
import com.test.service.StudentService;
import com.test.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		
		String info=request.getParameter("info");
		String[] h=request.getParameterValues("hobby");
		String hobby=Arrays.toString(h);
		hobby=hobby.substring(1, hobby.length()-1);
		//更新
		StudentService service=new StudentServiceImpl();
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student stu=new Student(sid,sname,gender,phone,date, hobby,info);
			service.update(stu);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
