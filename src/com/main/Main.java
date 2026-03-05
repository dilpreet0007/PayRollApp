package com.main;
import java.util.*;


import com.employee.User;
import com.salary.Item;
import com.salary.PayRollService;
import com.salary.PaySlip;
import com.auth.Auth;
import com.data.EmployeeData;
import com.employee.Employee;
import com.validator.ValidationException;
import com.validator.Validator;

/*
 * UC5 Pay is stored and displayed top 3 pays
 * @version 5.0
 * @author Dilpreet
 */

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
			Validator.isValidPass(pass);
			System.out.print("Enter your Email: ");
			String email = sc.nextLine();
			Validator.isValidEmail(email);
			System.out.print("Enter your PhoneNumber: ");
			String phoneNumber = sc.nextLine();
			Validator.isValidPhoneNumber(phoneNumber);
			System.out.print("Enter your EmpID: ");
			String empID = sc.nextLine();
			Validator.isValidEmpId(empID);
			
			User user = new User("David12","David@123","regular");
			Employee emp = new Employee("David","David@gmail.com","9898989898","davi121");
			
			User user2 = new User(userName,pass,"manager");
			Employee emp2 = new Employee(name,email,phoneNumber,empID);
			
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
			
			PaySlip slip = PayRollService.generatePayslip(emp2,"January",600000,30000,10000,12500);
			PaySlip slip1 = PayRollService.generatePayslip(emp2,"February",700000,35000,11000,12500);
			PaySlip slip2 = PayRollService.generatePayslip(emp2,"March",650000,32000,10500,12500);
			System.out.print(slip.toString());
			
			slip.savePayslipToFile();
			
			for(int i=0;i<PayRollService.pay.size() && i<3;i++) {
				Item item = PayRollService.pay.get(i);
				System.out.print(item.month + " --> " + item.value);
				System.out.println();
			}
			
			
		}
		catch(ValidationException e) {
			System.out.println(e.getMessage());
		}

	}

}
