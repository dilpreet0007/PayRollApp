package com.main;
import java.util.*;

import com.employee.User;
import com.employee.Employee;
import com.validator.ValidationException;
import com.validator.Validator;

public class Main {

	public static void main(String[] args) {
		System.out.println("=============Pay Roll App=============");
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter your Name: ");
			String name = sc.nextLine();
			System.out.print("Enter your UserName: ");
			String userName = sc.nextLine();
			System.out.print("Enter your Password: ");
			String pass = sc.nextLine();
			System.out.print("Enter your Email: ");
			String email = sc.nextLine();
			Validator.isValidEmail(email);
			System.out.print("Enter your PhoneNumber: ");
			String phoneNumber = sc.nextLine();
			Validator.isValidPhoneNumber(phoneNumber);
			System.out.print("Enter your EmpID: ");
			String empID = sc.nextLine();
			Validator.isValidEmpId(empID);
			
			User user = new User(userName,pass,"regular");
			Employee emp = new Employee(name,email,phoneNumber,empID);
			
		}
		catch(ValidationException e) {
			System.out.println(e.getMessage());
		}

	}

}
