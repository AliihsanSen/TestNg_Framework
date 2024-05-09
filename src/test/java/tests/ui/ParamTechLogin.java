package tests.ui;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class ParamTechLogin extends BaseTest{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Login negatif ui test")
    @Test(testName = "Geçersiz data ile login test",retryAnalyzer = RetryAnalyzer.class)
    public void testLogin() {

        Allure.step("Geçersiz data ile login girişi yapılamaz.");
        homePage
                .kullanici_anasayfaya_gider()
                .kullanici_kurumsal_login_sayfasina_gider();
        loginPage
                .kullanici_login_icin_yanlis_data_girer()
                .kullanici_hatali_bilgi_girisi_yaptiniz_mesajini_dogrular();
    }
}
