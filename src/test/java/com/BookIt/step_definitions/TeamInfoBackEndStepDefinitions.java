package com.BookIt.step_definitions;

import com.BookIt.pages.MyTeamPage;
import com.BookIt.utilities.BrowserUtils;
import com.BookIt.utilities.DBUtility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

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

        //get the actual name
        List<String> actualNames=BrowserUtils.getElementsText(myTeamPage.allNames);

        Assert.assertEquals(names.size(),actualNames.size());

        // make sure all names appear in the expected list
        for (Object name:names){
            Assert.assertTrue(actualNames.contains(name.toString()));
        }


    }


    List<Object> clusterTable;
    @Given("there is a list of clusters in the clusters table")
    public void there_is_a_list_of_clusters_in_the_clusters_table() {
        // get the list of id from clusters table
        String sql="select id from cluster;";
        clusterTable=DBUtility.getColumnData(sql,"id");
        System.out.println(clusterTable);


    }

    List<Object> roomTable;
    @And("all rooms have a clusters id in room table")
    public void all_rooms_have_a_clusters_id_in_room_table() {
        // get the list of cluster_id from the room table
        String sql="select * from room;";
        roomTable=DBUtility.getColumnData(sql,"cluster_id");
        System.out.println(roomTable);
    }

    @Then("all the clusters ids must be from the clusters table")
    public void all_the_clusters_ids_must_be_from_the_clusters_table() {
        // compare
        for (Object id:roomTable){
            Assert.assertTrue(clusterTable.contains(id));
        }
    }


}
