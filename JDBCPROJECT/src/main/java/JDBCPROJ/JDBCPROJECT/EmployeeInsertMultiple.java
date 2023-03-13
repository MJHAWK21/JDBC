package JDBCPROJ.JDBCPROJECT;

import java.sql.*;

public class EmployeeInsertMultiple {
  public static void main(String[] args) {
    // Set up database connection parameters
    String url = "jdbc:mysql://localhost:3306/meera";
    String username = "root";
    String password = "pass@word1";

    try {
      // Create a connection to the database
      Connection conn = DriverManager.getConnection(url, username, password);

      // Create a prepared statement for inserting data
      String sql = "INSERT INTO employee (name, age, department) VALUES (?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(sql);

      // Set the parameter values for multiple rows of data
      String[] names = {"ANUJA AJAY", "FINLA ANDREW", "AYSHA FATHIMA"};
      int[] ages = {23, 28, 42};
      String[] departments = {"DELIVERY", "RESEARCH", "DEPLOYEMENT"};

      for (int i = 0; i < names.length; i++) {
        pstmt.setString(1, names[i]);
        pstmt.setInt(2, ages[i]);
        pstmt.setString(3, departments[i]);
        pstmt.executeUpdate();
      }

      // Close the prepared statement and connection objects
      pstmt.close();
      conn.close();

      System.out.println("Data inserted successfully!");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

