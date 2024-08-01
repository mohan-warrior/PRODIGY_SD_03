package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO means data access object 
public class ConDao {
	
	
	  public static Connection creatCon() 
	  {
		  Connection con = null;
		  
		     try {
		    		// Register JDBC driver
		         try {
		        	 
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Class.forName("com.mysql.cj.jdbc.Driver") is used in Java to load and register the MySQL JDBC driver class dynamically at runtime.
					//Older versions or non-standard environments of JDBC required this explicit loading step to ensure the driver is registered.
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				con=DriverManager.getConnection("jdbc:mysql://localhost/prodigy","root","root");
		
		     System.out.println(con);
		     
		     } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		  
		     return con;
	  }
	  
	  
	  
	  
	  
	  

	     public static  int save(Contact e) {
	    	 
	    	    int status=0;
	    	    
	    	     
	    	       try {
	    	    	   Connection con=ConDao.creatCon();
					PreparedStatement ps= con.prepareStatement("insert into contacts (name,phone,email,country)values(?,?,?,?)");
			
	    	         ps.setString(1, e.getName());
	    	         ps.setString(2, e.getPhone());
	    	         ps.setString(3, e.getEmail());
	    	         ps.setString(4, e.getCountry());
					
	    	         status = ps.executeUpdate();//executeUpdate : Use for INSERT, UPDATE, DELETE, and DDL statements to modify data or the database structure.
	    	       
	    	       } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	 
	    	 
	    	 return status;
	     }
	     
	     
	     
	     
	     
	     
	     
	     

		public static List<Contact> getAllContact() {
			List<Contact> list =new ArrayList();
			
			
			try {
				Connection con = ConDao.creatCon();
				PreparedStatement ps= con.prepareStatement("select * from contacts");
				
				ResultSet rs = ps.executeQuery();//executeQuery : Used for SELECT statements to retrieve data.
				
				while(rs.next()) {
					Contact e = new Contact();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(2));
			    	e.setPhone(rs.getString(3));
			    	e.setEmail(rs.getString(4));
			    	e.setCountry(rs.getString(5));
			    	
			    	list.add(e);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		
		
		
		
		
		

		public static Contact getContactById(int id) {
			Contact e= new Contact();
	    	   
	    	  
   	        try {
   	    	      Connection con=ConDao.creatCon();
				  PreparedStatement ps= con.prepareStatement("select * from contacts where id=?");
			
   	              ps.setInt(1, id);
   	         
   	              ResultSet rs= ps.executeQuery();//executeQuery : Used for SELECT statements to retrieve data.
   	         
   	        if(rs.next())
   	           {
   	        	  e.setId(rs.getInt(1));
   	        	  e.setName(rs.getString(2));
   	        	  e.setPhone(rs.getString(3));
   	        	  e.setEmail(rs.getString(4));
   	        	  e.setCountry(rs.getString(5)); 
   	           }
   	     
   	     
   	     
   	        } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
   	 
   	        return e;
		}
		
		
		
		
		
		
		
		

		public static int Update(Contact e) {
			int status =0;
			
			try {
				Connection con = ConDao.creatCon();
				PreparedStatement ps= con.prepareStatement("update contacts set name=?,phone=?,email=?,country=? where id=?");
				
				ps.setString(1, e.getName());
				ps.setString(2, e.getPhone());
				ps.setString(3, e.getEmail());
		    	ps.setString(4, e.getCountry());
		    	ps.setInt(5, e.getId());
		    	
		    	status=ps.executeUpdate();//executeUpdate : Used for INSERT, UPDATE, DELETE, and DDL statements to modify data or the database structure.
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return status;
		}
		
		
		
		
		
		
		
		

		public static void Delete(int id) {
			
			
			 try {
				Connection con=ConDao.creatCon();
				PreparedStatement ps= con.prepareStatement("delete from contacts where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();//executeUpdate : Used for INSERT, UPDATE, DELETE, and DDL statements to modify data or the database structure.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	  
	  
}
