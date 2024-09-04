package Model;

public class Cart {
	private int id;
    private String name;
    private int price;
    private int quantity;
    public Cart(int id, String name,int price,int quantity) 
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String toString() {
    	return "Cart - -> [" +
    			"id=" + id +
    			",name=" + name +
    			",price=" + price+
    			",quantity=" + quantity+']';
    }

}
