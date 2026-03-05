package com.data;

import java.util.*;

import com.employee.Employee;
import com.employee.User;

public class EmployeeData {
	public static HashMap<String,User> userMap = new HashMap<>();
	public static HashMap<String,Employee> empMap = new HashMap<>();
	
	public static void addData(User user) {
		userMap.put(user.getUserName(),user);
	}
	
	public static void addData(Employee emp) {
		empMap.put(emp.getEmpId(), emp);
	}
}
