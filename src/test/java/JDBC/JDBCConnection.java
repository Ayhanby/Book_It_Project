package JDBC;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        while(resultSet.next()){

            System.out.println(resultSet.getString(1)+"-"+resultSet.getString("country_name")+"-"+resultSet.getString("region_id"));

        }




        resultSet.close();
        statement.close();
        connection.close();

    }



    @Test
    public void jdbcMetaData() throws SQLException,ClassNotFoundException{

        Class.forName("org.postgresql.Driver");
        Connection connection= DriverManager.getConnection(oracledbUrl,oracledbUsername,oraclePassword);
        Statement statement=connection.createStatement();

        String sql="select employee_id,last_name,job_id,salary from employees";
        //String sql="select * from employees";
        ResultSet resultSet=statement.executeQuery(sql);




        //Database metadata
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        System.out.println("User: "+databaseMetaData.getUserName());
        System.out.println("Database type: "+databaseMetaData.getDatabaseProductName());

        //resultSet metadata
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        System.out.println("Column count: "+resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getCatalogName(1));

        for (int i=1;i<=resultSetMetaData.getColumnCount();i++){
            System.out.println(i+" -> "+resultSetMetaData.getColumnName(i));
        }

         //Throw resultset into a List of Maps
        //Create a List of Maps
        List<Map<String,Object>> list=new ArrayList<>();
        ResultSetMetaData rsMdata=resultSet.getMetaData();

        int colCount=rsMdata.getColumnCount();

        while(resultSet.next()){
            Map<String,Object> rowMap=new HashMap<>();

            for(int col=1;col<=colCount;col++){
                rowMap.put(rsMdata.getColumnName(col),resultSet.getObject(col));
            }

            list.add(rowMap);
        }

        //print all employee ids from a list of maps

        System.out.println("Employee_id  Last_name  Job_id  Salary");
        for (Map<String,Object> emp:list) {

            System.out.println(emp.get("employee_id")+" - "+emp.get("last_name")+" - "+emp.get("job_id")+" - "+emp.get("salary"));
            
        }

        resultSet.close();
        statement.close();
        connection.close();




    }
}
