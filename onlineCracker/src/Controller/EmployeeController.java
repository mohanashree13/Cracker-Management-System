package Controller;

import Model.*;
public class EmployeeController {
	public static boolean addEmployee(String email,String name,String phoneNo) throws Exception
    {
        boolean b=EmployeeFunction.addEmployee(email,name,phoneNo);
        return b;
    }
	
	public static boolean removeEmployee(int id) throws Exception
    {
        boolean b=EmployeeFunction.removeEmployee(id);
        return b;
    }
}
