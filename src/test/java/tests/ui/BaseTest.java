package tests.ui;

import driver.DriverManager;
import lombok.extern.java.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;


import static driver.Driver.initDriver;
import static driver.Driver.quitDriver;

public class BaseTest {

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AccountPage accountPage;

    @BeforeMethod
    public void setup(){
        initDriver();
        homePage=new HomePage(DriverManager.getDriver());
        loginPage=new LoginPage(DriverManager.getDriver());
        accountPage=new AccountPage(DriverManager.getDriver());
    }

    @AfterMethod
    public void tearDown(){
        quitDriver();
    }
}
