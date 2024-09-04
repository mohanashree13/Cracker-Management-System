package View;

import java.time.LocalDate;
import java.util.List;

import java.util.Scanner;

import Controller.CrackerController;
import Model.Bill;
import Model.Cart;
import Model.Cracker;

public class CustomerView {
	static Scanner sc=new Scanner(System.in);
    public static void menu() throws Exception
    {
        boolean b=true;
        do
        {
            System.out.println(" 1.View cracker details \n 2.Add to cart \n 3.View add to cart \n 4.Buy \n 5.Generate bill \n 6.Exit");
            System.out.print("Enter details : ");
            int a = sc.nextInt();
            sc.nextLine();
            boolean t = true;
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
                        System.out.println("No Crackers found.");
                    break;
                case 2:
                	System.out.print("Enter cracker name:");
                	String name=sc.nextLine();
                	System.out.print("Enter quantity:");
                	int quantity=sc.nextInt();
                	int id=CrackerController.addId(name);
                	int price=CrackerController.addPrice(name);
                	int totalprice=price*quantity;
                	try
                    {
                        boolean ad=CrackerController.addToCart(id,name,totalprice,quantity);
                        if(ad)  System.out.println("Added to cart.");
                        else    
                        System.out.println("Failed to add cracker into cart.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to add cracker to cart.");
                    }
                    break;
                case 3:
                	List<Cart> cartList = CrackerController.viewCart();;
                    if (!cartList.isEmpty()) 
                    {
                        System.out.println("Add to cart:");
                        for (Cart ve : cartList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("No add to cart found.");
                    break;
                case 4:
                	System.out.print("Enter 1 to proceed buying or 2 to add extra crackers:");
                	int n=sc.nextInt();
                	sc.nextLine();
                	if(n==1)
                	{
                		while(t)
                		{
		                	System.out.print("Name of the cracker to buy:");
		                	String cname=sc.nextLine();
		                	System.out.print("Quantity:");
		                	int cquantity=sc.nextInt();
		                	sc.nextLine();
		                	int unit_price=CrackerController.addUnitPrice(cname);
		                	int finalprice=unit_price*cquantity;
		                	LocalDate date=LocalDate.now();
		                	try
		                    {
		                        boolean ad=CrackerController.addToBill(date,cname,finalprice,cquantity,unit_price);
		                        if(ad)  System.out.println("Added to bill.");
		                        else    
		                        System.out.println("Failed to add cracker into bill.");
		                    }
		                    catch(Exception e)
		                    {
		                        System.out.println("Failed to add cracker to bill.");
		                    }
		                	System.out.print("enter 1 to proceed or 2 to stop buying:");
		                	int s=sc.nextInt();
		                	sc.nextLine();
		                	if(s==1)
		                		t=true;
		                	else
		                		t=false;
                		}
                	}
                	break;
                case 5:
                	List<Bill> billList = CrackerController.viewBill();;
                    if (!billList.isEmpty()) 
                    {
                        System.out.println("Your Bill:");
                        for (Bill ve : billList)
                            System.out.println(ve);
                    } 
                    else
                        System.out.println("Bill not found.");
                    break;
                case 6:
                    try
                    {
                    	boolean uc=CrackerController.deleteTable();
                        if(uc)  System.out.println("Add to cart has been removed from the database.");
                        else    
                        System.out.println("Failed to remove add to cart from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove add to cart from the database.");
                    }
                    try
                    {
                    	boolean uc=CrackerController.deleteBill();
                        if(uc)  System.out.println("Your bill has been removed from the database.");
                        else    
                        System.out.println("Failed to remove bill from the database.");
                    }
                    catch(Exception e)
                    {
                        System.out.println("Failed to remove bill from the database.");
                    }
                    System.out.println("Thank you for the purchase");
                    b=false;
                    break;
            }
        }
        while(b);
    } 

}
