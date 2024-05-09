package pages;

import driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static constants.FrameworkConstants.getHomePageUrl;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="menu_login") private WebElement girisYapButon;
    @FindBy(xpath = "//a[@href='https://isyerim.param.com.tr/#/']") private  WebElement kurumsalGirisButon;

    public HomePage kullanici_anasayfaya_gider(){
        Allure.step("Kullanıcı "+getHomePageUrl()+" sayfasına gider.");
        navigateTo_URL(getHomePageUrl());
        return this;
    }
    public LoginPage kullanici_kurumsal_login_sayfasina_gider(){
        Allure.step("Kullanıcı kurumsal login sayfasına gider.");
        click(girisYapButon);
        String paramWindow= DriverManager.getDriver().getWindowHandle();
        jsScrollClick(kurumsalGirisButon);
        switchToNewWindow(paramWindow);
        return new LoginPage(driver);
    }
}
