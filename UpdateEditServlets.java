package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditServlet2")
public class UpdateEditServlets extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost is used when we submit/store data to/in server when user fills the form and content is not shown in url
		//example: user registration form 
		
		response.setContentType("text/html");
		
		
		 PrintWriter out= response.getWriter();
		 
		 out.print("<h1>Update Contact</h1>");
		 
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 
			String name= request.getParameter("name");
			String phone = request.getParameter("phone");
			String email= request.getParameter("email");
			String country=request.getParameter("country");
			
		 
			Contact e= new Contact();
			
			  e.setId(id);//It is Important to setId because on basis of id only we will update the database, 
//			                id is important even though it is auto-incremented(the update method needs to know on which id the edit is applied)
			  e.setName(name);
			  e.setEmail(email);
			  e.setPhone(phone);
			  e.setCountry(country);
			  
			  System.out.println(e);
		
		
			  int status = ConDao.Update(e);
			  
			  if(status > 0)
			   {
				   response.sendRedirect("ViewServlet");
			   }else
			   {
				   out.print("Something went wrong");
			   }
	}

}
