package com.BookIt.step_definitions;

import com.BookIt.pages.MyTeamPage;
import com.BookIt.utilities.BrowserUtils;
import com.BookIt.utilities.DBUtility;
import cucumber.api.java.en.Then;

import java.util.List;

public class TeamInfoBackEndStepDefinitions {

    @Then("team information should match database records")
    public void team_information_should_match_database_records()  {
        //get the name of the team, it will be used to get team id

        MyTeamPage myTeamPage=new MyTeamPage();
        BrowserUtils.wait(3);
        String teamName=myTeamPage.teamName.getText();
        System.out.println(teamName);

        String sql= "select u.firstname " +
                " from users u join team t on t.id = " +
                " u.team_id and t.name = '"+teamName+"';";

        // get ColumnData returns data of a single column

        List<Object> names= DBUtility.getColumnData(sql,"firstname");

        System.out.println(names);


    }

}
