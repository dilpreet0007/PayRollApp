package com.auth;

import com.data.EmployeeData;
import com.employee.User;

public class Auth {
	public static boolean auth(String userName,String pass) {
		if(!EmployeeData.userMap.containsKey(userName)) {
			System.out.println("UserName does not exist");
			return false;
		}
		
		User user = EmployeeData.userMap.get(userName);
		
		String hashPas = HashPassword.hashPassword(pass);
		
		if(hashPas.equals(user.getPass())) {
			return true;
		}
		System.out.println("Wrong Password!!");
		
		return false;
		
	}
}
