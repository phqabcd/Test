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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取客户端的数据
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		//checkbox和radio为空传递的值较特殊，是"null"
		if(("null").equals(gender))
			gender="";
		String phone=request.getParameter("phone");
		String birthday=request.getParameter("birthday");
		String info=request.getParameter("info");
//		String hobby=request.getParameter("hobby");//有多个爱好
		String[] h=request.getParameterValues("hobby");
		String hobby=Arrays.toString(h);
		hobby=hobby.substring(1,hobby.length()-1);//[1,n)
		if(("ul").equals(hobby))
			hobby="";
		//string -> date
		Date date = null;
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student=new Student(sname,gender,phone, date, hobby,info);
		System.out.println(student);
		StudentService service=new StudentServiceImpl();
		try {
			service.insert(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
