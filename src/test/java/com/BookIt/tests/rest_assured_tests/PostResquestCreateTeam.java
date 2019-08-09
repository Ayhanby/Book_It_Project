package com.BookIt.tests.rest_assured_tests;

import com.BookIt.utilities.BookItRestUtility;
import com.BookIt.utilities.DBUtility;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;

public class PostResquestCreateTeam {


    String accessToken;

    @BeforeClass
    public static void setUp(){

        RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com/";
    }

    @Test
    public void createTeam(){

        String token= BookItRestUtility.getTeacherToken();

        // make a post request
        String team="ahmetjanyus";
        RestAssured.given().
                header("Authorization",token).
                queryParam("campus-location","VA").
                queryParam("batch-number","8").
                queryParam("team-name",team).
                post("/api/teams/team").
                then().log().all().statusCode(201).
                body(containsString("added"));
        verifyTeamExists(team);

    }
    public static void verifyTeamExists(String team){

        DBUtility.createConnection();
        String sql="select * from team where name='"+team+"';";
        System.out.println(sql);
        Map<String,Object> result =  DBUtility.getRowMap(sql);
        Assert.assertNotNull(result);
    }




}
