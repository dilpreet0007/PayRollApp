package com.salary;

public class SalaryComponent {
	public static double basicSalary;
	public static double hra;
	public static double da;
	public static double allowances;
	public static double pf;
	public static double tax;
	public static double netPay;
	
	public SalaryComponent(double basicSalary, double hra,double da,double allowances) {
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.da = da;
		this.allowances = allowances;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getDa() {
		return da;
	}

	public void setDa(double da) {
		this.da = da;
	}

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}

	public double getPf() {
		return pf;
	}

	public void setPf(double pf) {
		this.pf = pf;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}
	
	
}
