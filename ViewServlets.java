package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlets extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet method is used to retrieve the data from the server that is requested by the user and content is shown in url
		//example: search form in web application
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.print("<a href='Index.html'>Add New Contact</a>");
		
		
		List<Contact> list=ConDao.getAllContact();
		   
		   
//		   for(Employee e : list)
//		   {
//			    out.print(e.getId() +"<br>");
//			    out.print(e.getName() +"<br>") ;
//			    out.print(e.getPassword() +"<br>");
//			    out.print(e.getEmail() +"<br>");
//			    out.print(e.getCountry() +"<br>");
//			   
//		   }
		
		   out.print("<h1>Contact List</h1>");
		   out.print("<table border='10' width=100% cellspacing='0' cellpadding='10'>");
		     out.print("<tr>");
		     out.print("<th>Id</th>");
		     out.print("<th> Name </th>");
             out.print("<th> password </th>");
             out.print("<th>Email </th>");
             out.print("<th> Country </th>");
             out.print("<th> Edit </th>");
             out.print("<th> Delete </th>");
		     out.print("</tr>");	
		     
		     for(Contact e :list) {
		    	 out.print("<tr>");
	               out.print("<td>"+e.getId()+"</td>");
	               out.print("<td> "+ e.getName()+" </td>");
	               out.print("<td> "+e.getPhone() +" </td>");
	               out.print("<td> "+e.getEmail() +" </td>");
	               out.print("<td> "+e.getCountry() +" </td>");
	               out.print("<td> <a href='EditServlet?id="+e.getId()+"'>Edit</a> </td>");
	               out.print("<td> <a href='DeleteServlet?id="+e.getId()+"'>Delete</a> </td>");
	               
	             out.print("</tr>");
		     }
		   out.print("</table>");
	}
}
