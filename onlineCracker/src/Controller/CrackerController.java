package Controller;

import java.time.LocalDate;
import java.util.List;

import Model.Bill;
import Model.Cart;
import Model.Cracker;
import Model.CrackerFunction;

public class CrackerController {
	public static List<Cracker> viewAllCrackers()
    {
        List<Cracker> st =CrackerFunction.viewAllCrackers();
        return st;
    }
	public static boolean addCracker(int id,String cname,int price,int stock) throws Exception
    {
        try
        {
            boolean b=CrackerFunction.addCracker(id,cname,price,stock);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
    public static boolean removeCracker(int idForDelete) throws Exception
    {
        boolean b=CrackerFunction.removeCracker(idForDelete);
        return b;
    }
    public static List<Cart> viewCart()
    {
        List<Cart> st =CrackerFunction.viewCart();
        return st;
    }
    public static int addId(String name) throws Exception
    {
    	try
    	{
    		int id=CrackerFunction.addId(name);
    		return id;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The id is not available");
    	}
    }
    public static int addPrice(String name) throws Exception
    {
    	try
    	{
    		int price=CrackerFunction.addPrice(name);
    		return price;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The price is not available");
    	}
    }
    public static boolean addToCart(int id,String name,int totalprice,int quantity) throws Exception
    {
        try
        {
            boolean b=CrackerFunction.addToCart(id,name,totalprice,quantity);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
    public static int addUnitPrice(String cname) throws Exception
    {
    	try
    	{
    		int unit_price=CrackerFunction.addUnitPrice(cname);
    		return unit_price;
    	}
    	catch(Exception e)
    	{
    		throw new Exception("The price is not available");
    	}
    }
    public static boolean addToBill(LocalDate date,String cname,int finalprice,int cquantity,int unit_price) throws Exception
    {
        try
        {
            boolean b=CrackerFunction.addToBill(date,cname,finalprice,cquantity,unit_price);
            return b;
        }
        catch(Exception e)
        {
            throw new Exception("The insertion isn't performed");
        }
    }
    public static List<Bill> viewBill()
    {
        List<Bill> st =CrackerFunction.viewBill();
        return st;
    }
    public static boolean deleteTable() throws Exception
    {
    	boolean b=CrackerFunction.deleteTable();
    	return b;
    }
    public static boolean deleteBill() throws Exception
    {
    	boolean b=CrackerFunction.deleteBill();
    	return b;
    }
}
