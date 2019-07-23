package com.BookIt.utilities;

import com.BookIt.pages.HomePage;
import com.BookIt.pages.LoginPage;
import excelautomation.EmployeesFormPage;

public class Pages {

    public LoginPage loginPage;
    public HomePage homePage;
    protected EmployeesFormPage employeesFormPage;
    public HomePage homePage(){
        homePage=new HomePage();
        return homePage;
    }
    public LoginPage login(){

        if(loginPage==null){
            loginPage=new LoginPage();
        }

        return loginPage;
    }


}
