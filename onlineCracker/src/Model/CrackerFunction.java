package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CrackerFunction {
	public  static List<Cracker> viewAllCrackers()
    {
        List<Cracker> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM cracker");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                st.add(new Cracker(id,name,price,stock));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
	public  static List<Cart> viewCart()
    {
        List<Cart> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM add_to_cart");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                st.add(new Cart(id,name,price,quantity));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
	public static boolean addCracker(int id,String cname,int price,int stock) throws SQLException {
        String sql = "INSERT INTO cracker (id,name,price,stock) VALUES (?, ?, ?, ?)";
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, cname);
            statement.setInt(3, price);
            statement.setInt(4, stock);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
    public static boolean removeCracker(int idForDelete) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "DELETE FROM cracker WHERE id = ?")) 
        {
            statement.setInt(1, idForDelete);
            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();
            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB ERROR");
        }
    }
    public static int addId(String name) throws Exception
    {
    	int id = -1;
		try (
                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                        "SELECT id FROM cracker WHERE name = ?")) 
           {
               statement.setString(1, name);
               ResultSet resultSet = statement.executeQuery();
               if (resultSet.next()) {
                   id = resultSet.getInt("id");;
               } 
               resultSet.close();
               statement.close();
           } 
    	catch (SQLException e) {
               e.printStackTrace();
               throw new Exception("DB ERROR");
           }
    	return id;
    }
    public static int addPrice(String name) throws Exception
    {
    	int price =-1;
		try (
                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                        "SELECT price FROM cracker WHERE name = ?")) 
           {
               statement.setString(1, name);
               ResultSet resultSet = statement.executeQuery();
               if (resultSet.next()) {
                   price = resultSet.getInt("price");;
               } 
               resultSet.close();
               statement.close();
           } 
    	catch (SQLException e) {
               e.printStackTrace();
               throw new Exception("DB ERROR");
           }
    	return price;
    }
    public static boolean addToCart(int id,String name,int totalprice,int quantity) throws SQLException {
        String sql = "INSERT INTO add_to_cart (id,name,price,quantity) VALUES (?, ?, ?, ?)";
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2,name);
            statement.setInt(3, totalprice);
            statement.setInt(4, quantity);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
    public static boolean addToBill(LocalDate date,String cname,int finalprice,int cquantity,int unit_price) throws SQLException {
        String sql = "INSERT INTO bill (date,name,total_price,quantity,unit_price) VALUES (?, ?, ?, ?, ?)";
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
        	Date sqldate=Date.valueOf(date);
            statement.setDate(1, sqldate);
            statement.setString(2,cname);
            statement.setInt(3, finalprice);
            statement.setInt(4, cquantity);
            statement.setInt(5, unit_price);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
    public static int addUnitPrice(String cname) throws Exception
    {
    	int unit_price =-1;
		try (
                PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                        "SELECT price FROM cracker WHERE name = ?")) 
           {
               statement.setString(1, cname);
               ResultSet resultSet = statement.executeQuery();
               if (resultSet.next()) {
                   unit_price = resultSet.getInt("price");;
               } 
               resultSet.close();
               statement.close();
           } 
    	catch (SQLException e) {
               e.printStackTrace();
               throw new Exception("DB ERROR");
           }
    	return unit_price;
    }
    public  static List<Bill> viewBill()
    {
        List<Bill> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM bill");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                int purchase_id = resultSet.getInt("purchase_id");
                Date date = resultSet.getDate("date");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                int unit_price = resultSet.getInt("unit_price");
                int total_price = resultSet.getInt("total_price");
                st.add(new Bill(purchase_id,date,name,quantity,total_price,unit_price));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
    public static boolean deleteTable() throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "DELETE FROM add_to_cart")) 
        {
            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();
            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB ERROR");
        }
    }
    public static boolean deleteBill() throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "DELETE FROM bill")) 
        {
            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();
            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("DB ERROR");
        }
    }
}
