package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class ParamTechAccountApi extends BaseTestApi{

    @Severity(SeverityLevel.CRITICAL)
    @Step("Account negatif api test")
    @Test(testName = "Geçersiz onay mesaji ile api test",retryAnalyzer = RetryAnalyzer.class)
    public void testAccountApi() {

        Allure.step("Geçersiz onay mesaji ile hesap oluşturulamaz.");
        accountApi
                .kullanici_sms_icin_expected_data_olusturur()
                .kullanici_sms_icin_request_gonderir_response_alir()
                .kullanici_sms_dogrular_verificationNo_alir()
                .kullanici_verify_icin_expected_data_olusturur()
                .kullanici_verify_icin_request_gonderir_response_alir()
                .kullanici_verify_icin_dogrulama_yapar();
    }
}
