package com.ihusain;

import com.ihusain.dao.EmployeeDao;
import com.ihusain.dao.EmployeeDaoImpl;
import com.ihusain.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
        // save employee
        EmployeeDao empDao = new EmployeeDaoImpl();
        empDao.saveEmployee(new Employee("John", 1000));
    }
}
