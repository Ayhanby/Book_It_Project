package excelautomation;

import com.BookIt.utilities.BrowserUtils;
import com.BookIt.utilities.Driver;
import com.BookIt.utilities.ExcelUtil;
import com.BookIt.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class DataDrivenTest extends TestBase {

    List<Map<String,String>> testData;

    @BeforeMethod
    public void getTestData(){
        ExcelUtil excelUtil=new ExcelUtil("./src/test/resources/EmployeesTestData.xlsx","data");
        testData=excelUtil.getDataList();
    }


    @Test
    public void employeeFormTest(){




           for(Map<String, String> employeesData:testData){

               Driver.getDriver().get("https://forms.zohopublic.com/yura1/form/JobApplicationForm/formperma/V5jfS1yKkAxhDq_8BJmrQm4MaRI3rBUPCjB31ZbyOXI");


            EmployeesFormPage employeesFormPage=new EmployeesFormPage();

            employeesFormPage.firstName.sendKeys(employeesData.get("first_name"));
            employeesFormPage.lastName.sendKeys(employeesData.get("last_name"));
            employeesFormPage.role.sendKeys(employeesData.get("role"));
            employeesFormPage.email.sendKeys(employeesData.get("email"));
            employeesFormPage.selectGender(employeesData.get("gender"));
            new Select(employeesFormPage.education).selectByVisibleText(employeesData.get("education"));
            new Select(employeesFormPage.Certifications).selectByVisibleText(employeesData.get("certifications"));
            employeesFormPage.ref1FirstName.sendKeys(employeesData.get("Ref first_name"));
            employeesFormPage.ref1LastName.sendKeys(employeesData.get("Ref last_name"));
            employeesFormPage.ref1Email.sendKeys(employeesData.get("Ref email"));
            employeesFormPage.Apply.click();

        BrowserUtils.wait(3);

        Assert.assertEquals(employeesFormPage.successfullySubmitted.getText(),employeesFormPage.message);



           }
    }
}
