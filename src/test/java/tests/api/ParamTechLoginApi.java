package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class ParamTechLoginApi extends BaseTestApi{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Login negatif api test")
    @Test(testName = "Geçersiz data ile login api test",retryAnalyzer = RetryAnalyzer.class)
    public void testLoginApi() {

        Allure.step("Geçersiz data ile login api girişi yapılamaz.");
        loginApi
                .kullanici_login_icin_expected_data_olusturur()
                .kullanici_login_icin_request_gonderir_response_alir()
                .kullanici_giris_yapilamadigini_dogrular();
    }
}
