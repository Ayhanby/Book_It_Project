package com.BookIt.tests.fucntionality_tests.LogOut;

import com.BookIt.utilities.ApplicationConstants;
import com.BookIt.utilities.ConfigurationReader;
import com.BookIt.utilities.Driver;
import com.BookIt.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logout extends TestBase {

    @Test
    public void LogoutTest()throws InterruptedException{

        extentLogger=report.createTest("Logout Functionality Test");
        extentLogger.info("Logging into BookIt Application");
        pages.login().logIn(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
        Thread.sleep(3000);
        extentLogger.info("Verifying successfully loged in");
        Assert.assertEquals(Driver.getDriver().getTitle(), ApplicationConstants.BOOK_IT_PAGE_TITLE);
        Thread.sleep(3000);
        extentLogger.info("Clicking my model on the left top menu");
        actions.moveToElement(pages.login().my).click().moveToElement(pages.login().SignOut).perform();

        Thread.sleep(3000);
        extentLogger.info("Veriying successfully Logout");
        Assert.assertEquals(pages.login().Header1,ApplicationConstants.BOOK_IT_PAGE_HEADER);


    }
}
