package com.BookIt.utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.SQLException;

public class DBTestBase {




    @BeforeMethod
    public void setUp() throws SQLException,ClassNotFoundException{

        DBUtility.establishConnection(DBType.POSTGRESQL);

    }

    @AfterMethod
    public void tearDown(){

        DBUtility.closeConnection();

    }
}
