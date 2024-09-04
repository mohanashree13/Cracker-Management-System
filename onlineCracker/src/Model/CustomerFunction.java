package Model;

import java.io.EOFException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFunction {
	public  static List<Customer> viewAllCustomers()
    {
        List<Customer> st = new ArrayList<>();
        try (
        PreparedStatement statement = DBconnectivity.getConnection().prepareStatement("SELECT * FROM customer");
        ResultSet resultSet = statement.executeQuery()) 
        {
            while (resultSet.next()) 
            {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String phoneNo = resultSet.getString("phoneNo");
                String address = resultSet.getString("address");
                st.add(new Customer(email,name,phoneNo,address));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return st;
    }
	public static boolean addCustomer(String email,String name,String phoneNo,String address)throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "INSERT INTO customer (email,name,phoneNo,address) VALUES (?, ?, ?, ?)");) 
        {
            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, phoneNo);
            statement.setString(4, address);
            // Execute the SQL INSERT statement
            int rowsInserted = statement.executeUpdate();
            // Check if the insertion was successful
            if (rowsInserted > 0)
                return true;
            else
                return false;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new EOFException("DB error");
        }
    }

}
