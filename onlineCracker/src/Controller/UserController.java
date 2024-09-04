package Controller;
import Model.*;
import View.*;

public class UserController
{
    public  boolean validateUser(String email,String pass) throws Exception
    {
        try
        {
            String dbpass=UserFunction.getPassword(email);
            if(dbpass.equals(pass))
                return true;
            else 
                return false;
        }
        catch(Exception e)
        {
            throw new Exception("Enter valid Details");
        }
    }
    public void chooseMenu(String email)throws Exception
    {
        try
        {
            String role=UserFunction.getRoleByEmail(email);
            if(role.equals("admin"))
                AdminView.menu();
            else if(role.equals("employee"))
            {
                    EmployeeView.menu();
            }
            else 
                CustomerView.menu();
        }
        catch(Exception e)
        {
            throw new Exception("Error During choosing role");
        }
    }
    public static boolean addUser(String email,String pass,String role) throws Exception
    {
        try
        {
            boolean b=UserFunction.addUser(email,pass,role);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
    public static boolean removeUser(String email) throws Exception
    {
        boolean b=UserFunction.removeUser(email);
        return b;
    } 
}