package Model;

public class Employee {
	private int id;
    private String email;
    private String name;
    private String phoneNo;
    public Employee(int id,String email, String name, String phoneNo) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String toString() {
    	return " Employees - ->[" +
    			"id=" + id +
    			",name=" + name +
    			",email=" + email+
    			",Phone number=" + phoneNo+']';
    }
}
