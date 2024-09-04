package Model;

public class Customer {

    private String email;
    private String name;
    private String phoneNo;
    private String address;
    public Customer(String email, String name, String phoneNo,String address) 
    {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address=address;
    }
    public String toString() {
    	return "Customers - ->[" +
    			"name=" + name +
    			",email=" + email +
    			",Phone number=" + phoneNo+
		    	",address=" + address+']';
    }
}
