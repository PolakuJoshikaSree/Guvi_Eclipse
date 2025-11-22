package com.app.hdfc.service;

import java.util.List;
import com.app.hdfc.model.Employee;

public class HDFCBankService {

    public double getTotalAmountPaidByHDFC(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getCompany().equalsIgnoreCase("HDFC"))
                .mapToDouble(Employee::getAmountPaid)
                .sum();
    }
}
