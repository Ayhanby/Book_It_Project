package com.BookIt.tests.fucntionality_tests.Login;

import com.BookIt.utilities.ApplicationConstants;
import com.BookIt.utilities.ConfigurationReader;
import com.BookIt.utilities.Driver;
import com.BookIt.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLogin extends TestBase {



    @Test
    public void PositiveLoginTest()throws InterruptedException {

        extentLogger=report.createTest("Positive Login Functionality Test");
        extentLogger.info("Opening URL");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Thread.sleep(3000);
        extentLogger.info("Verifying the page");
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.BOOK_IT_PAGE_TITLE);
        extentLogger.info("Entering valid email credential");
        pages.login().logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        Thread.sleep(5000);
        extentLogger.info("Verifying successfuly login");
        Assert.assertEquals(Driver.getDriver().getTitle(),ApplicationConstants.BOOK_IT_PAGE_TITLE);




    }





}
