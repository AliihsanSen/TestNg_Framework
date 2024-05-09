package tests.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;


public class HerokuAppApi extends BaseTestApi{

    @Severity(SeverityLevel.CRITICAL)
    @Step("HerokuApp post ve delete method kullanımı")
    @Test(testName = "HerokuApp post ve delete method kullanımı",retryAnalyzer = RetryAnalyzer.class)
     public void testPostAndDelete(){

        Allure.step("Kullanıcı kayıt oluşturabilmeli ve oluşturduğu kaydi silebilmelidir.");
         herokuApp
                 .kullanici_kayit_icin_expected_data_olusturur()
                 .kullanici_kayit_icin_request_gonderir_response_alir()
                 .kullanici_kayit_isleminin_dogrulamasini_yapar()
                 .kullanici_login_gerceklestirir_token_alir()
                 .kullanici_olusturdugu_kaydi_siler_ve_dogrular();
     }
}
