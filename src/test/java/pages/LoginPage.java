package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.FrameworkConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "userCardNo") private WebElement gsmBox;
    @FindBy(name = "userPassword") private  WebElement sifreBox;
    @FindBy(id = "loginbutton") private  WebElement loginButon;
    @FindBy(className = "modalTitle___WE5UD") private  WebElement uyariMesaji;
    @FindBy(className = "signUp___3OOhy") private  WebElement hesapOlusturButon;

    public LoginPage kullanici_login_icin_yanlis_data_girer(){
        Allure.step("Kullanıcı login için yanlış data girer.");
        enterText(gsmBox,getInvalidPhoneNumber());
        enterText(sifreBox,getInvalidPassword());
        jsScrollClick(loginButon);
        return this;
    }
    public LoginPage kullanici_hatali_bilgi_girisi_yaptiniz_mesajini_dogrular(){
        waitForVisibility(uyariMesaji);
        Allure.step("Kullanıcı " + uyariMesaji.getText() + " uyari mesajını doğrular.");
        assertThat(uyariMesaji.getText(),containsString(getHataliBilgiGirisiYaptinizMesaji()));
        return this;
    }
    public AccountPage kullanici_hesap_olustur_sayfasina_gider(){
        Allure.step("Kullanıcı hesap olustur sayfasına gider.");
        jsScrollClick(hesapOlusturButon);
        return new AccountPage(driver);
    }
}
