package com.BookIt.step_definitions;


import com.BookIt.utilities.BookItRestUtility;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class CreateUserAPIStepDefinition {

    String token;
    Response postResponse;

    @Given("the user has access token as a student")
    public void the_user_has_access_token_as_a_student() {
        token = BookItRestUtility.getStudentToken();
        System.out.println("token = " + token);
    }

    @When("the user creates a new student")
    public void the_user_creates_a_new_student() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + faker.internet().domainName();
        String password = firstName.toLowerCase() + lastName.toLowerCase();
        String role = "student-team-member";
        int batch = 8;
        String teamName = "CodeHunters";
        String campus = "VA";


        postResponse = given().
                header("Authorization", token).
                queryParam("first-name", firstName).
                queryParam("last-name", lastName).
                queryParam("email", email).
                queryParam("password", password).
                queryParam("role", role).
                queryParam("campus-location", campus).
                queryParam("batch-number", batch).
                queryParam("team-name", teamName).
                when().
                post("/api/students/student");

    }

    @Then("the new student should not be created")
    public void the_new_student_should_not_be_created() {
        postResponse.then().log().all();
        postResponse.then().assertThat().statusCode(403).
                body(containsString("only teacher allowed to modify database."));

    }

    @Given("the user has access token as a teacher")
    public void the_user_has_access_token_as_a_teacher() {
        token = BookItRestUtility.getTeacherToken();
    }

    @Then("the new student should be created")
    public void the_new_student_should_be_created() {
        postResponse.then().log().all();
        postResponse.then().assertThat().statusCode(201).
                body(containsString("has been added to database"));

    }


}
