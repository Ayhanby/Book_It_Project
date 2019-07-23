package com.BookIt.pages;

import com.BookIt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//h1[.='Quick Launchpad']")
    public WebElement Header;

    @FindBy(xpath = "//h2[@class='subtitle']")
    public WebElement locations;

    @FindBy(linkText = "my")
    public WebElement my;

    @FindBy(linkText = "sign out")
    public WebElement SignOut;


    @FindBy(id = "kuzzat_cave-121")
    public WebElement KuzzatsCave;


    @FindBy(name = "username")
    public WebElement username1;

    @FindBy(name = "password")
    public WebElement password1;

    @FindBy(xpath = "//div//div[@id='flash']")
    public WebElement message1;

    @FindBy(xpath = "//div[@class='map']//span")
    public List<WebElement> rooms;

    @FindBy(xpath = "//a[.='map']")
    public WebElement map;

    @FindBy(xpath = "//a[.='hunt']")
    public WebElement hunt;

    @FindBy(xpath = "//a[.='self']")
    public WebElement self;

    @FindBy(xpath = "//a[.='team']")
    public WebElement team;

    @FindBy(xpath = "//p[.='name']/../p[1]")
    public List<WebElement> teamMembers;

    @FindBy(xpath = "//p[.='Aldridge Grimsdith']")
    public WebElement selfName;

    @FindBy(xpath = "//p[.='student-team-member']")
    public WebElement selfRole;

    @FindBy(xpath = "//p[.='Rangers']")
    public WebElement selfTeam;

    @FindBy(xpath = "//p[.='#7']")
    public WebElement selfBatch;

    @FindBy(xpath = "//p[.='VA']")
    public WebElement selfCampus;

    @FindBy(xpath = "//p[.='dark-side']")
    public WebElement selfSide;

    @FindBy(xpath = "(//p[@class='subtitle is-7'])[1]")
    public WebElement capacityQuote;






    public void goToSelf(){
        HomePage homePage=new HomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(homePage.my).click().moveToElement(homePage.self).click().perform();

    }

    public void goToTeam(){
        HomePage homePage=new HomePage();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(homePage.my).click().moveToElement(homePage.team).click().perform();

    }

    public WebElement room(String roomName){

        return Driver.getDriver().findElement(By.linkText(roomName));
    }


}
