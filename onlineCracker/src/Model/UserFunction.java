package Model;
import java.sql.*;
public class UserFunction
{
    public static String getPassword(String email)  throws Exception
    {
        String password = null;
        String sql = "SELECT password FROM users WHERE email = ?";
        try (PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) 
        {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                if (resultSet.next()) 
                    password = resultSet.getString("password");
                else 
                    throw new SQLException("User with email " + email + " not found.");
                }
            }
        return password;
    }
    public static String getRoleByEmail(String email) throws Exception 
    {
        String role = null;
        String sql = "SELECT role FROM users WHERE email = ?";
        try (PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) 
        {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) 
            {
                if (resultSet.next())
                    role = resultSet.getString("role");
                else 
                    throw new SQLException("User with email " + email + " not found.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw e; // Re-throw the exception to propagate it to the caller
        }
        return role;
    }
    public static boolean addUser(String email, String password, String role) throws SQLException {
        String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, role);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            throw e; // Re-throw the exception to propagate it to the caller
        }
    }
    public static boolean removeUser(String email) throws Exception
    {
        try (
             PreparedStatement statement = DBconnectivity.getConnection().prepareStatement(
                     "DELETE FROM users WHERE email = ?")) 
        {
            statement.setString(1, email);
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
