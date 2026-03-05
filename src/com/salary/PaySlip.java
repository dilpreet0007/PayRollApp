package com.salary;

import com.employee.Employee;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PaySlip {
	private Employee employee;
	private SalaryComponent salaryComponent;
	private String month;
	
	public PaySlip(Employee employee, SalaryComponent salaryComponent, String month) {
		this.employee = employee;
		this.salaryComponent = salaryComponent;
		this.month = month;
	}
	
	public String toString() {
        return "\n======= PAYSLIP ==========\n"
            + "Month        : " + month + "\n"
            + "Employee ID  : " + employee.getEmpId() + "\n"
            + "Employee Name: " + employee.getName() + "\n\n"
            + "----- Earnings -----\n"
            + "Basic Salary : " + SalaryComponent.basicSalary + "\n"
            + "HRA          : " + SalaryComponent.hra + "\n"
            + "DA           : " + SalaryComponent.da + "\n"
            + "Allowances   : " + SalaryComponent.allowances + "\n\n"
            + "----- Deductions -----\n"
            + "PF           : " + SalaryComponent.pf + "\n"
            + "Tax          : " + SalaryComponent.tax + "\n\n"
            + "Net Pay      : " + SalaryComponent.netPay + "\n"
            + "============================\n";
	}
	
	
	public void savePayslipToFile() {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("payslip.txt"));
	        writer.write(this.toString());
	        writer.close();

	        System.out.println("Payslip saved successfully.");

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
