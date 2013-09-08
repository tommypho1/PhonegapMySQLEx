package com.dn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dn.entity.Users;

public class UsersDao {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/phonggapDB";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "Ilovehightech123";
	   
	   private Connection conn = null;
	   private PreparedStatement  stmt = null;
	   
	   public String createUser (Users user){
		   
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
		   
			   //Open a connection
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
			   //Execute a sql command
			   String sql;
			   sql = "INSERT INTO Users (firstName, lastName) VALUES (?,?);";
			   stmt = conn.prepareStatement(sql);
			   stmt.setString(1,user.getFirstName());
			   stmt.setString(2,user.getLastName());
			   stmt.executeUpdate();
			   
			   //close
			   stmt.close();
			   conn.close();
		   
			   return "yes";
		   
		   }
		   catch(SQLException se){
			   return "no";
		   }
		   catch(Exception e){
			   return "no";
		   }
	   }
	   
	   public Users findById (int id){
		   Users user = new Users();
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
		   
			   //Open a connection
			   conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   
			   //Execute a sql command
			   String sql;
			   sql = "SELECT * FROM Users WHERE id=?";
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1,id);
			   
			   ResultSet rs = stmt.executeQuery();
			      
			   //Extract data from result set
			   while(rs.next()){
				   //Retrieve by column name
			       user.setFirstName(rs.getString("firstName"));
			       user.setLastName(rs.getString("lastName"));
			       user.setId(id);
			   }
			   
			   //close
			   rs.close();
			   stmt.close();
			   conn.close();
		   
			   return user;
		   
		   }
		   catch(SQLException se){
			   return null;
		   }
		   catch(Exception e){
			   return null;
		   }
	   }
	   
}
