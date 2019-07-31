package com.BookIt.step_definitions;

import com.BookIt.utilities.DBUtility;
import com.BookIt.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {




    @Before(value = "@teammember",order = 2)
    public void setUpTeammember(){

        System.out.println("Set up user login test ");
    }


    @Before()
    public void setUp(){
        System.out.println("I am setting up the class from Hooks class ");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before(value = "@db")
    public void setUpDBConnection(){
        DBUtility.createConnection();
    }

    @After(value = "@db")
    public void closeConnection(){
        DBUtility.closeConnection();
    }

    @After
    public void tearDown(Scenario scenario)throws InterruptedException{
        System.out.println("I am reporting the result");

        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }

        System.out.println("Closing Driver");
        Thread.sleep(10000);
        Driver.closeDriver();
    }


}
