package com.BookIt.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookItRestUtility {

    public static void main(String[] args) {
        System.out.println(getTeacherToken());
        System.out.println(getStudentToken());
    }

    private static String teacherToken;
    private static String studentToken;

    public static String getTeacherToken() {
        if (teacherToken == null) {
            RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

            Response response = given().
                    param("email", "teacherva5@gmail.com").
                    param("password", "maxpayne").
                    get("/sign");
            response.then().assertThat().statusCode(200);
            teacherToken = response.jsonPath().get("accessToken");
        }
        return teacherToken;

    }

    public static String getStudentToken() {
        if (studentToken == null) {
            RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";
            Response response = given().
                    param("email", "nshearsby7w@uiuc.edu").
                    param("password", "lorettebradnum").
                    get("/sign");
            response.then().assertThat().statusCode(200);
            studentToken = response.jsonPath().get("accessToken");
        }
        return studentToken;

    }


}
