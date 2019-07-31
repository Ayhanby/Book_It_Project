package JDBC;

import com.BookIt.utilities.DBUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class test {

    @Test
    public void countTest()throws SQLException, ClassNotFoundException{



        int rowCount= DBUtility.getRowCount("select * from employees where job_id='IT_PROG'");
        Assert.assertTrue(rowCount>0);



    }

}
