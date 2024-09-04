package Model;

public class Cracker {
	private int id;
    private String name;
    private int price;
    private int stock;
    public Cracker(int id, String name,int price,int stock) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public String toString() {
    	return "Crackers - -> [" +
    			"id=" + id +
    			",name=" + name +
    			",price=" + price+
    			",stock=" + stock+']';
    }

}
