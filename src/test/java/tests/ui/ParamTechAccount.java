package tests.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class ParamTechAccount extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Account negetif test")
    @Test(testName = "Geçersiz onay mesaji ile test",retryAnalyzer = RetryAnalyzer.class)
    public void testAccount(){

        Allure.step("Kullanıcı geçersiz onay mesaji ile hesap oluşturamaz.");
        homePage
                .kullanici_anasayfaya_gider()
                .kullanici_kurumsal_login_sayfasina_gider();
        loginPage
                .kullanici_hesap_olustur_sayfasina_gider();
        accountPage
                .kullanici_hesap_olusturmak_icin_gerekli_datalari_girer()
                .kullanici_gelen_onay_mesajindaki_sifreyi_yanlis_girer()
                .kullanici_girdiginiz_onay_kodu_hatalidir_uyari_mesajini_dogrular();



    }
}
