package tests.api;


import apis.heroku.HerokuApp;
import apis.paramTech.account.AccountApi;
import apis.paramTech.login.LoginApi;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestApi {

    protected LoginApi loginApi;
    protected AccountApi accountApi;
    protected HerokuApp herokuApp;

    @BeforeMethod
    public void setup(){
    loginApi = new LoginApi();
    accountApi = new AccountApi();
    herokuApp=new HerokuApp();
    }

    @AfterMethod
    public void tearDown(){

    }
}
