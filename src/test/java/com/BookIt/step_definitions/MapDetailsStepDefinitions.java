package com.BookIt.step_definitions;

import com.BookIt.pages.HomePage;
import com.BookIt.utilities.ApplicationConstants;
import com.BookIt.utilities.BrowserUtils;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class MapDetailsStepDefinitions {

    @Then("user should be able to see {string}")
    public void user_should_be_able_to_see(String roomName) {
        System.out.println("Checking the room name");

        HomePage homePage = new HomePage();

        List<String> allRoom = BrowserUtils.getElementsText(homePage.rooms);


        Assert.assertTrue(allRoom.contains(ApplicationConstants.MAP_DETAILS_DARKSIDE_KUZZATSCAVE));


    }

    @Then("user should be able to see following conference room:")
    public void user_should_be_able_to_see_following_conference_room(List<String> rooms) {
        System.out.println(rooms);


    }
}
