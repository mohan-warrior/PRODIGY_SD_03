package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveServlet2 extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost is used when we submit/store data to/in server when user fills the form and content is not shown in url
		//example: user registration form 
	
		response.setContentType("text/html");
		
		
		PrintWriter out= response.getWriter();
		
		
		String name= request.getParameter("name");
		String phone = request.getParameter("phone");
		String email= request.getParameter("email");
		String country=request.getParameter("country");
		
		
		Contact e= new Contact();
		  e.setName(name);
		  e.setEmail(email);
		  e.setPhone(phone);
		  e.setCountry(country);
		  
		  System.out.println(e);
		  
		   int ans = ConDao.save(e);
		   
		   System.out.println();
		   
		   if(ans>0)
		   {
			    out.print("<h1>data saved successfully</h1>");
			    request.getRequestDispatcher("Index.html").include(request, response);
		   }else
		   {
			   out.print("something went wrong");
		   }
		
		
	}

}

