package com.BookIt.pages;

import com.BookIt.utilities.ConfigurationReader;
import com.BookIt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage{

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[.='sign in']")
    public WebElement Header1;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SignInButton;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement warningMessage;




    public void logIn(String username, String password){
        LoginPage loginPage=new LoginPage();

       Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().fullscreen();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.SignInButton.click();
    }

    public void login(String username, String password){
        LoginPage loginPage=new LoginPage();

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.SignInButton.click();
    }

    public void open(){
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url"));
    }

}
