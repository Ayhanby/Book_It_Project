package JDBC;

import com.BookIt.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.sql.*;

public class TeamNameTest {

    @Test
    public void team() throws SQLException,ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(ConfigurationReader.getProperty("pgadminUrl"),
                ConfigurationReader.getProperty("pgUsername"),ConfigurationReader.getProperty("pgPassword"));
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from team");

        while(resultSet.next()){

            System.out.println(resultSet.getString(1)+"-"+resultSet.getString("name")+"-"+resultSet.getString("batch_number"));

        }




        resultSet.close();
        statement.close();
        connection.close();
    }

}
