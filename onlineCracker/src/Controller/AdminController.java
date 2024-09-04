package Controller;

import java.util.List;

import Model.*;

public class AdminController {
	public static List<Employee> viewAllEmployees()
    {
        List<Employee> st =EmployeeFunction.viewAllEmployees();
        return st;
    }
	public static List<Customer> viewAllCustomers()
    {
        List<Customer> st =CustomerFunction.viewAllCustomers();
        return st;
    }
}
