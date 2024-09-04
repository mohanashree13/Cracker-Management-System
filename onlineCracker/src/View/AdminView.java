package View;

import java.util.List;
import java.util.Scanner;

import Controller.AdminController;
import Controller.CrackerController;
import Controller.EmployeeController;
import Controller.UserController;
import Model.Cracker;
import Model.Customer;
import Model.Employee;

public class AdminView {
	static Scanner sc=new Scanner(System.in);
    public static void menu()
    {
        boolean b=true;
        do
        {
            System.out.println("**********************************");
            System.out.println(" 1.View employee \n 2.View customer \n 3.View crackers \n 4.Add employee \n 5.Remove employee "
            		+ "\n 6.Add crackers \n 7.Remove crackers \n 8.Exit");
            System.out.println("**********************************");
            System.out.print("Choose a number to perform operation : ");
            int a = sc.nextInt();
            switch(a)
            {
                case 1:
                	List<Employee> employeesList = AdminController.viewAllEmployees();;
                    if (!employeesList.isEmpty()) 
                    {
                        System.out.println("List of Employees:");
                        for (Employee ve : employeesList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Employee found.");
                    break;
                case 2:
                	List<Customer> customersList = AdminController.viewAllCustomers();;
                    if (!customersList.isEmpty()) 
                    {
                        System.out.println("List of Customers:");
                        for (Customer ve : customersList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Customer found.");
                    break;
                case 3:
                	List<Cracker> crackersList = CrackerController.viewAllCrackers();;
                    if (!crackersList.isEmpty()) 
                    {
                        System.out.println("	List of Crackers:	");
                        for (Cracker ve : crackersList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No Cracker found.");
                    break;
                case 4:
                    System.out.print("Enter email: ");
                    String email = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Phone number : ");
                    String phoneNo = sc.next();
                    try
                    {
                        boolean uc=UserController.addUser(email, password,"employee");
                        boolean bt=EmployeeController.addEmployee(email,name,phoneNo);
                        if(uc&&bt)  System.out.println("A new employee has been inserted into the database.");
                        else    
                        System.out.println("Failed to insert employee into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert employee into the database.");
                    }
                	break;
                case 5:
                	System.out.print("Enter the employee ID to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the employee email to delete: ");
                    String email1 = sc.next();
                    try
                    {
                    	boolean uc=UserController.removeUser(email1);
                        boolean ad=EmployeeController.removeEmployee(idToDelete);
                        if(ad&&uc)  System.out.println("Employee has been removed from the database.");
                        else    
                        System.out.println("Failed to remove employee from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove employee from the database.");
                    }
                	break;
                case 6:
                	System.out.print("Enter cracker id: ");
                    int  id= sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter cracker name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter cracker price: ");
                    int price = sc.nextInt();
                    System.out.print("Enter stock available : ");
                    int stock = sc.nextInt();
                    try
                    {
                        boolean uc=CrackerController.addCracker(id,cname,price,stock);
                        if(uc)  System.out.println("A new cracker has been inserted into the database.");
                        else    
                        System.out.println("Failed to insert cracker into the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to insert cracker into the database.");
                    }
                	break;
                case 7:
                	System.out.print("Enter the cracker ID to delete: ");
                    int idForDelete = sc.nextInt();
                    try
                    {
                        boolean uc=CrackerController.removeCracker(idForDelete);
                        if(uc)  System.out.println("Cracker has been removed from the database.");
                        else    
                        System.out.println("Failed to remove cracker from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove cracker from the database.");
                    }
                	break;
                case 8:
                    System.out.println("Thank you");
                    b=false;
                    break;
            }
        }
        while(b);
    } 

}
