package com.BookIt.tests.rest_assured_tests;

import com.BookIt.utilities.BookItRestUtility;
import com.BookIt.utilities.BrowserUtils;
import com.BookIt.utilities.DBUtility;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentResourceEndToEnd {


// Test Case: User creation and update End to End scenario

// CREATE

    // Create a new random user using the Add a Student end point
    //verify status code 201
    // verify response message
    // get the new user details from the database
    // get the new user details from get a student by id end point
    // verify both information is accurate
    //login to the application using the new user and verify user logged in


// Update

    //verify the status
    // update the user password using the Update a student endpoint
    // try to login to the application using the old pass and verify not //logged in to the applcation using the new pass and verify logged


//DELETE

    // verify the status code
    //verify that in database user with that email does not exist
    // try to login to the application and verify not logged

    Logger log=Logger.getLogger(StudentResourceEndToEnd.class);

    @Test
    public void postStudent(){

        // create test data

        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=firstName.toLowerCase()+lastName.toLowerCase()+faker.internet().emailAddress();
        String password=firstName.toLowerCase()+lastName.toLowerCase();
        String role="student-team-member";
        String campusLocation="VA";
        String batchNumber="8";
        String teamName="CodeHunters";

        String token= BookItRestUtility.getTeacherToken();
        String expectedMessage="user "+firstName+" "+lastName+" has been added to database.";

        given().
                header("Authorization",token).
                queryParam("first-name",firstName).
                queryParam("last-name",lastName).
                queryParam("email",email).
                queryParam("password",password).
                queryParam("role",role).
                queryParam("campus-location",campusLocation).
                queryParam("batch-number",batchNumber).
                queryParam("team-name",teamName).
                when().post("api/students/student").
                then().log().all().
                assertThat().statusCode(201).
                body(is(expectedMessage));

        // get the new user from database
        Map<String,Object> dbUder=getDBUser(email);
        log.info(dbUder);
        // verify the database data has the correct info
        assertThat(dbUder.get("firstname"),is(firstName));
        assertThat(dbUder.get("lastname"),is(lastName));
        assertThat(dbUder.get("email"),is(email));
        //verify that id is not empty
        assertThat(dbUder.get("id"),is(notNullValue()));

        // get the user info database using API

        String id=dbUder.get("id").toString();
        given().
                log().all().
                header("Authorization",token).
                pathParam("id",id).
                when().
                get("/api/students/{id}").
                then().
                log().all().
                assertThat().statusCode(200).
                body("firstName",is(firstName)).
                body("lastName",is(lastName)).
                body("role",is(role));

        // verify using UI
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password+ Keys.ENTER);
        BrowserUtils.wait(5);
        assertThat(driver.getCurrentUrl(),endsWith("map"));



    }

    public static Map<String,Object> getDBUser (String email){
        DBUtility.createConnection();
        String sql="select firstname,lastname,role,email,id from users where email='"+email+"';";
        Map<String,Object> rowMap=DBUtility.getRowMap(sql);
        DBUtility.closeConnection();

        return rowMap;

    }



}
