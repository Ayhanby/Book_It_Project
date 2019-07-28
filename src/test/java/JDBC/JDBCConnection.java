package JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class JDBCConnection {


    String  oracledbUrl="jdbc:postgresql://room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/hr";
    String  oracledbUsername="hr";
    String  oraclePassword="hr";

    @Test
    public void oracleJDBC() throws SQLException, ClassNotFoundException {


       Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(oracledbUrl,oracledbUsername,oraclePassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from countries");

        resultSet.next();
        System.out.println(resultSet.getString("country_name"));

        resultSet.close();
        statement.close();
        connection.close();

    }
}
