package com.BookIt.step_definitions;

import com.BookIt.pages.HomePage;
import com.BookIt.utilities.BrowserUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class MyTeamStepDefinitions {

    @Then("user goes to the {string} page")
    public void user_goes_to_the_page(String page) {

        HomePage homePage=new HomePage();

        switch (page){
            case "map":
                homePage.map.click();
                break;
            case "hunt":
                homePage.hunt.click();
                break;
            case "my self":
                homePage.goToSelf();
                break;
            case "my team":
                homePage.goToTeam();
                break;
        }


    }

    @And("following team members should be displayed:")
    public void following_team_members_should_be_displayed(List<String> members) {

        System.out.println(members);

        HomePage homePage=new HomePage();

        List<String> myTeam= BrowserUtils.getElementsText(homePage.teamMembers);
        Assert.assertTrue(members.containsAll(myTeam));

    }

}
