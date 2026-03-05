package com.salary;

import com.employee.Employee;

public class PayRollService {

    public static PaySlip generatePayslip(Employee employee, String month,
                                   double basic, double hra, double da, double allowances) {

        SalaryComponent sc = new SalaryComponent(basic, hra, da, allowances);

        double gross = basic + hra + da + allowances;

        sc.setPf(basic * 0.12); 
        sc.setTax(gross * 0.10);    


        sc.setNetPay(gross - (sc.getPf() + sc.getTax()));

        return new PaySlip(employee, sc, month);
    }
}