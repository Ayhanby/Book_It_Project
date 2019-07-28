package JDBC;

import com.BookIt.utilities.DBType;
import com.BookIt.utilities.DBUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeesDbTest {


    @Test
    public void countTest()throws SQLException, ClassNotFoundException{

        //Connect to postgresql database
        //run following sql query
        //select * from employees where job_id='IT_PROG'
        //more than one records should return

        DBUtility.establishConnection(DBType.POSTGRESQL);
        int rowCount=DBUtility.getRowsCount("select * from employees where job_id='IT_PROG'");
        Assert.assertTrue(rowCount>0);
        DBUtility.closeConnection();


    }


    @Test
    public void nameTestByID()throws SQLException,ClassNotFoundException{

        //Connect to postgresql database
        //run following sql query
        //employees first name and last name with Employee id 105 should David Austin
        DBUtility.establishConnection(DBType.POSTGRESQL);

        List<Map<String,Object>> empData=DBUtility.runSQLQuery("SELECT first_name,last_name FROM employees WHERE employee_id=105");

        Assert.assertEquals(empData.get(0).get("first_name"),"David");
        Assert.assertEquals(empData.get(0).get("last_name"),"Austin");

        DBUtility.closeConnection();




    }

}
