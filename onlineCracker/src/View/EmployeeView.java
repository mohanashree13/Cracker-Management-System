package View;
import java.util.*;

import Controller.CrackerController;
import Model.Cracker;
public class EmployeeView 
{
    static Scanner sc=new Scanner(System.in);
    public static void menu()
    {
        boolean b=true;
        do
        {
            System.out.println(" 1.Display cracker details \n 2.Exit");
            System.out.print("Enter details : ");
            int a = sc.nextInt();
            switch(a)
            {
                case 1:
                	List<Cracker> crackersList = CrackerController.viewAllCrackers();;
                    if (!crackersList.isEmpty()) 
                    {
                        System.out.println("List of Crackers:");
                        for (Cracker ve : crackersList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("Crackers out of stock");
                    break;
                case 2:
                    System.out.println("Thank you for your purchase");
                    b=false;
                    break;
            }
        }
        while(b);
    } 
}