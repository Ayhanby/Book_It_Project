package excelautomation;

import com.BookIt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeesFormPage  {


    protected Select select;
    protected String message="Thank you! Your data has been submitted.";

     public EmployeesFormPage(){
         PageFactory.initElements(Driver.getDriver(),this);
     }



     @FindBy(xpath = "//input[@name='Name_First']")
     public WebElement firstName;

     @FindBy(name = "Name_Last")
    public WebElement lastName;

    @FindBy(name = "SingleLine1")
    public WebElement role;


    @FindBy(id = "Radio_1")
    public WebElement male;

    @FindBy(id = "Radio_2")
    public WebElement female;

    @FindBy(name = "Dropdown")
    public WebElement education;


    @FindBy(name = "Dropdown1")
    public WebElement Certifications;



    @FindBy(name = "Email")
    public WebElement email;

    @FindBy(name = "Name1_First")
    public WebElement ref1FirstName;

    @FindBy(name="Name1_Last")
    public WebElement ref1LastName;

    @FindBy(name = "Email1")
    public WebElement ref1Email;

    @FindBy(xpath = "//em[.='Apply']")
    public WebElement Apply;

    @FindBy(xpath = "//span[@class='alignCenter']")
    public WebElement successfullySubmitted;



    public void selectGender(String gender) {
        if (gender.toLowerCase().equals("male")) {
            if (!male.isSelected()) {
                male.click();

            }
        } else if (gender.toLowerCase().equals("female")) {
            if (!female.isSelected()) {
                female.click();

            }
        }
    }




}
