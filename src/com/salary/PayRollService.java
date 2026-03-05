package com.salary;

import java.util.ArrayList;
import java.util.Collections;


import com.employee.Employee;


public class PayRollService {
	
	public static ArrayList<Item> pay = new ArrayList<>();

    public static PaySlip generatePayslip(Employee employee, String month,
                                   double basic, double hra, double da, double allowances) {

        SalaryComponent sc = new SalaryComponent(basic, hra, da, allowances);

        double gross = basic + hra + da + allowances;

        sc.setPf(basic * 0.12); 
        sc.setTax(gross * 0.10);    


        sc.setNetPay(gross - (sc.getPf() + sc.getTax()));
        
        pay.add(new Item(month,sc.getNetPay()));
        
        Collections.sort(pay, (a, b) -> Double.compare(b.value, a.value));

        return new PaySlip(employee, sc, month);
    }
}