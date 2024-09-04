package Controller;

import Model.CustomerFunction;

public class CustomerController {
	public static boolean addCustomer(String email,String name,String phoneNo,String address) throws Exception
    {
        boolean b=CustomerFunction.addCustomer(email,name,phoneNo,address);
        return b;
    }

}
