package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteServlet")
public class DeleteServlets extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		 PrintWriter out= response.getWriter();
		 
		 
		 int id= Integer.parseInt(request.getParameter("id"));
		 
		      ConDao.Delete(id);
		      
		      
		      response.sendRedirect("ViewServlet");
		
	}
}
