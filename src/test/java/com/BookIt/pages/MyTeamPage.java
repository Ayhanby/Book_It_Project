package com.BookIt.pages;

import com.BookIt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyTeamPage extends HomePage {

    public MyTeamPage(){PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(css = "h2[class='subtitle']")
    public WebElement teamName;


    @FindBy(xpath = "//p[.='name']/../p[1]")
    public List<WebElement> allNames;

    @FindBy(xpath = "//p[.='role']/../p[1]")
    public List<WebElement> allRoles;

}
