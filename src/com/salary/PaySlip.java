package com.salary;

import com.employee.Employee;

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
	
}
