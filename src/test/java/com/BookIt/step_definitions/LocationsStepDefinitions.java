package com.BookIt.step_definitions;

import com.BookIt.pages.HomePage;
import com.BookIt.pages.LoginPage;
import com.BookIt.utilities.BrowserUtils;
import com.BookIt.utilities.ConfigurationReader;
import com.BookIt.utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class LocationsStepDefinitions {

    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am on the login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        System.out.println("I am clicking the login button");
        LoginPage loginPage=new LoginPage();
        loginPage.SignInButton.click();
    }

    @Then("locations should be {string}")
    public void locations_should_be(String location) {
        System.out.println("Checking the campus location");
        System.out.println("Campus location is "+location);
        BrowserUtils.wait(2);
        HomePage homePage=new HomePage();
        Assert.assertEquals(homePage.locations.getText(),location);
    }



}
