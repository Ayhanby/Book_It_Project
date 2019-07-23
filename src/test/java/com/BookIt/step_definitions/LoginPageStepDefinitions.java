package com.BookIt.step_definitions;

import com.BookIt.pages.LoginPage;
import com.BookIt.utilities.ApplicationConstants;
import com.BookIt.utilities.ConfigurationReader;
import com.BookIt.utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefinitions {

    @Given("The user is on login page")
    public void the_user_is_on_login_page() {
        System.out.println("I am openning the login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("user logs in as team lead")
    public void user_logs_in_as_team_lead() {
        System.out.println("I am logging in as team lead");
    }

    @When("user logs in as team member")
    public void user_logs_in_as_team_member() {
        System.out.println("I am logging in as team member");
    }

    @When("user logs in as teacher")
    public void user_logs_in_as_teacher() {
        System.out.println("I am logging in as teacher");
    }


    @And("clicks on login button")
    public void clicks_on_login_button()throws InterruptedException{
        System.out.println("I am clicking login button");
        LoginPage loginPage=new LoginPage();
        loginPage.SignInButton.click();
        Thread.sleep(5000);
    }

    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        System.out.println("I am seeing the homepage");
    }

    @And("title should be correct")
    public void title_should_be_correct() {
        System.out.println("Checking the homepage");
        System.out.println("title: "+ Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(),ApplicationConstants.BOOK_IT_PAGE_TITLE);
    }





}


