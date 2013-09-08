package com.dn.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.dn.dao.UsersDao;
import com.dn.entity.Users;

@Path("/Dao")
public class MyRest { 
	  
	  @GET
	  @Path("/getUserById/{id}")
	  @Produces({"application/xml", "application/json"})
	  public Users getUser(@PathParam("id") int id) {
		  UsersDao usersDao = new UsersDao();
		  Users user = usersDao.findById(id);
		  return user;
	  }
	  
	  @POST
	  @Path("/CreateUser/{firstName}/{lastName}")
	  @Consumes()
	  public void createUser(@PathParam("firstName") String firstName,
			  				  @PathParam("lastName") String lastName) {
		  UsersDao usersDao = new UsersDao();
		  Users user = new Users();
		  user.setFirstName(firstName);
		  user.setLastName(lastName);
		  usersDao.createUser(user);
	  }
}
