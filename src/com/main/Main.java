package com.main;
import java.util.*;


import com.employee.User;
import com.salary.PayRollService;
import com.salary.PaySlip;
import com.auth.Auth;
import com.data.EmployeeData;
import com.employee.Employee;
import com.validator.ValidationException;
import com.validator.Validator;

public class Main {

	public static void main(String[] args) {
		System.out.println("=============Pay Roll App=============");
		
		Scanner sc = new Scanner(System.in);
		
//		try {
//			System.out.print("Enter your Name: ");
//			String name = sc.nextLine();
//			System.out.print("Enter your UserName: ");
//			String userName = sc.nextLine();
//			System.out.print("Enter your Password: ");
//			String pass = sc.nextLine();
//			System.out.print("Enter your Email: ");
//			String email = sc.nextLine();
//			Validator.isValidEmail(email);
//			System.out.print("Enter your PhoneNumber: ");
//			String phoneNumber = sc.nextLine();
//			Validator.isValidPhoneNumber(phoneNumber);
//			System.out.print("Enter your EmpID: ");
//			String empID = sc.nextLine();
//			Validator.isValidEmpId(empID);
			
			User user = new User("David12","David123","regular");
			Employee emp = new Employee("David","David@gmail.com","9898989898","davi121");
			
			User user2 = new User("Soe12","Soe321","manager");
			Employee emp2 = new Employee("soe","soe@gmail.com","9898989877","soe2122");
			
			EmployeeData.userMap.put(user.getUserName(), user);
			EmployeeData.empMap.put(emp.getEmpId(), emp);
			
			EmployeeData.userMap.put(user2.getUserName(), user2);
			EmployeeData.empMap.put(emp2.getEmpId(), emp2);
			
			System.out.println("----------Login-----------");
			System.out.print("Enter your UserName: ");
			String u = sc.nextLine();
			System.out.print("Enter your Password: ");
			String p = sc.nextLine();
			
			boolean logedIn = Auth.auth(u, p);
			
			if(logedIn) System.out.println("Login Succesfull!!");
			
			PaySlip slip = PayRollService.generatePayslip(emp,"January",600000,30000,10000,12500);
			
			System.out.print(slip.toString());
			
			
//		}
//		catch(ValidationException e) {
//			System.out.println(e.getMessage());
//		}

	}

}
