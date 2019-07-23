package com.BookIt.step_definitions;

import com.BookIt.pages.HomePage;
import com.BookIt.pages.LoginPage;
import com.BookIt.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class MyDetailsStepDefinition {

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String username, String password) {
        System.out.println("I am loging in");
        System.out.println("username: "+username);
        System.out.println("password: "+password);

        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Then("user should see his information:")
    public void user_should_see_his_information(Map<String, String> userInfo) {
        System.out.println(userInfo);

        String name=userInfo.get("name");
        System.out.println("name = "+name);

        String role=userInfo.get("role");
        System.out.println("role = "+role);

        String team=userInfo.get("team");
        System.out.println("team = "+team);

        String batch=userInfo.get("batch");
        System.out.println("batch = "+batch);

        String campus=userInfo.get("campus");
        System.out.println("campus = "+campus);



        HomePage homePage=new HomePage();
        String actualName=homePage.selfName.getText();
        String actualRole=homePage.selfRole.getText();
        String actualTeam=homePage.selfTeam.getText();
        String actualBatch=homePage.selfBatch.getText();
        String actualCampus=homePage.selfCampus.getText();


        Assert.assertEquals(name,actualName);
        Assert.assertEquals(role,actualRole);
        Assert.assertEquals(team,actualTeam);
        Assert.assertEquals(batch,actualBatch);
        Assert.assertEquals(campus,actualCampus);


    }

    @Then("user should be able to see quotes info for each room")
    public void user_should_be_able_to_see_quotes_info_for_each_room(Map<String, String> rooms) {
        System.out.println(rooms);

        for (String room:rooms.keySet()){
            System.out.println(room);

            HomePage homePage=new HomePage();
            homePage.room(room).click();

            Assert.assertEquals(rooms.get(room),homePage.capacityQuote.getText());
            Driver.getDriver().navigate().back();

        }


    }

}
