package com.dn.test;

import com.dn.dao.UsersDao;
import com.dn.entity.Users;

public class TestDao {
	public static void main(String[] args) {
		UsersDao usersDao = new UsersDao();
		Users user = new Users();
		user.setFirstName("Nina");
		user.setLastName("Liu");
		String result = usersDao.createUser(user);
		if (result.equals("yes"))
			System.out.println("User created successfully\n");
		else
			System.out.println("User created fail\n");
		
		Users userDB = usersDao.findById(2);
		if (userDB != null)
		{
			System.out.println("ID = " + userDB.getId());
			System.out.println("fistName = " + userDB.getFirstName());
			System.out.println("lastName = " + userDB.getLastName());
		}
	}
}
