package com.validator;

public class Validator {
	public static void isValidEmail(String email) throws ValidationException{
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		
		if(!email.matches(emailRegex)) {
			throw new ValidationException("Invalid Email");
		}
	}
	
	public static void isValidPhoneNumber(String num) throws ValidationException{
		String numRegex = "^[0-9]{10}$";
		if(!num.matches(numRegex)) {
			throw new ValidationException("Invalid Phone number");
		}
	}
	public static void isValidEmpId(String empId) throws ValidationException{
		String empIdRegex = "^[A-Za-z0-9]{6,10}$";
		
		if(!empId.matches(empIdRegex)) {
			throw new ValidationException("Invalid EmpID");
		}
	}
}
