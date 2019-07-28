package com.BookIt.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static int rowsCount;


    public static void establishConnection(DBType dbType)throws SQLException,ClassNotFoundException {

        switch (dbType){
            case ORACLE:
                connection= DriverManager.getConnection(ConfigurationReader.getProperty("oracle.url"),
                        ConfigurationReader.getProperty("oracle.username"),
                        ConfigurationReader.getProperty("oracle.password"));

                break;

            case POSTGRESQL:
                Class.forName("org.postgresql.Driver");
                connection= DriverManager.getConnection(ConfigurationReader.getProperty("postgres.url"),
                        ConfigurationReader.getProperty("postgres.username"),
                        ConfigurationReader.getProperty("postgres.password"));

                break;

                default:
                    connection=null;
        }

    }

    public static int getRowsCount(String sql)throws SQLException{

        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(sql);
        resultSet.last();
        return resultSet.getRow();
    }


    public static List<Map<String,Object>> runSQLQuery(String sql)throws SQLException{
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(sql);

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

        return list;

    }

    public static void closeConnection() {

        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    }

