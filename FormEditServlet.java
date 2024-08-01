package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet")
public class FormEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet method is used to retrieve the data from the server that is requested by the user and content is shown in url
		//example: search form in web application
		
		response.setContentType("text/html");
		
		
		 PrintWriter out= response.getWriter();
		 
		 out.print("<h1>Update Employee</h1>");
		 
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 Contact e = ConDao.getContactById(id);
		 
		 out.print("<div style='width:300px;padding:20px; border:4px solid black;'>");
		 out.print("<form action='EditServlet2' method='post'>");//from here it will go another Servlet 
		 
//		 out.print("<h2>ID :</h2>");
		 out.print("<input type='hidden' name='id' value='"+e.getId()+"'>");
		 out.print("<h2>Name : </h2>");
		 out.print("<input type='text' name='name' value='"+e.getName()+"'>");
		 out.print("<h2>Password: </h2>");
		 out.print("<input type='text' name='password' value='"+e.getPhone()+"'>");
		 out.print("<h2>Email: </h2>");
		 out.print("<input type='text' name='email' value='"+e.getEmail()+"'>");
		 out.print("<h2>Country : </h2>");
		 out.print("<select name='country' >");
		 out.print("<option>India</option>");
		 out.print("<option>Usa</option>");
		 out.print("<option>Uk</option>");
		 out.print("<option>other</option>");
		 out.print("</select>");
		 
		 out.print("<br><br><input type='submit' value='Edit&save'>");
		 
		 out.print("</form>");
		 out.print("</div>");
		
	}
}
