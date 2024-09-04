package Model;

import java.sql.Date;

public class Bill {
	private int purchase_id;
	private Date date;
    private String name;
    private int unit_price;
    private int quantity;
    private int total_price;
    public Bill(int purchase_id,Date date,String name,int unit_price,int quantity,int total_price) 
    {
        this.purchase_id = purchase_id;
        this.name = name;
        this.date=date;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.total_price=total_price;
    }
    public String toString() {
    	return "Bill - ->[" +
    			"purchase_id=" + purchase_id +
    			",date="+date+
    			",name='" + name +
    			",unit_price='" + unit_price+
    			"'total_price='"+total_price+
    			",quantity=" + quantity+']';
    }

}
