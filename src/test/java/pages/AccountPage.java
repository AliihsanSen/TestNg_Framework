package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static constants.FrameworkConstants.*;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "name") private WebElement adBoxInput;
    @FindBy(name = "surname") private  WebElement soyadiBoxInput;
    @FindBy(name = "email") private  WebElement emailBoxInput;
    @FindBy(name = "gsmNumber") private  WebElement gsmBoxInput;
    @FindBy(name = "checkBox1") private  WebElement checkBox1;
    @FindBy(name = "checkBox2") private  WebElement checkBox2;
    @FindBy(name = "checkBox3") private  WebElement checkBox3;
    @FindBy(name = "checkBox4") private  WebElement checkBox4;
    @FindBy(id = "continue_from_signup") private  WebElement devamButon;
    @FindBy(name = "input1") private  WebElement input1;
    @FindBy(name = "input2") private  WebElement input2;
    @FindBy(name = "input3") private  WebElement input3;
    @FindBy(name = "input4") private  WebElement input4;
    @FindBy(name = "input5") private  WebElement input5;
    @FindBy(name = "input6") private  WebElement input6;
    @FindBy(id = "continue_from_otp") private  WebElement onaylaButon;
    @FindBy(id = "errorVerificationNo") private  WebElement uyariMesaji;

    public AccountPage kullanici_hesap_olusturmak_icin_gerekli_datalari_girer(){
        Allure.step("Kullanici hesap olusturmak için gerekli datalari girer.");
        enterText(adBoxInput,getValidName());
        enterText(soyadiBoxInput,getValidSurName());
        enterText(emailBoxInput,getValidEmail());
        enterText(gsmBoxInput,getValidPhoneNumber());
        if(!checkBox1.isSelected()){
            click(checkBox1);
        }
        if (!checkBox2.isSelected()){
            click(checkBox2);
        }
        if (!checkBox3.isSelected()){
            click(checkBox3);
        }
        if(!checkBox4.isSelected()){
            click(checkBox4);
        }
        jsScrollClick(devamButon);
        return this;
    }
    public AccountPage kullanici_gelen_onay_mesajindaki_sifreyi_yanlis_girer(){
        Allure.step("Kullanıcı gelen onay mesajındaki sifreyi yanlış girer.");
        enterText(input1,getInvalidPassword().substring(0,1));
        enterText(input2,getInvalidPassword().substring(1,2));
        enterText(input3,getInvalidPassword().substring(2,3));
        enterText(input4,getInvalidPassword().substring(3,4));
        enterText(input5,getInvalidPassword().substring(4,5));
        enterText(input6,getInvalidPassword().substring(5));
        jsScrollClick(onaylaButon);
        return this;
    }
    public AccountPage kullanici_girdiginiz_onay_kodu_hatalidir_uyari_mesajini_dogrular(){
        Allure.step("Kullanıcı "+uyariMesaji.getText()+" uyari mesajını doğrular.");
        softAssert.assertEquals(uyariMesaji.getText(),getGirdiginizOnayKoduHatalidirMesaji());
        softAssert.assertAll();
        return this;
    }
}
