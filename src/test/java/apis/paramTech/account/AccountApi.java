package apis.paramTech.account;

import apis.paramTech.login.LoginApi;
import apis.paramTech.login.PayloadLoginPojo;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static constants.FrameworkConstants.*;


public class AccountApi {
    Map<String,Object> expectedData;
    Response response;
    public int verificationNo;

    public AccountApi kullanici_sms_icin_expected_data_olusturur(){
        Allure.step("Kullanici sms almak için expected data oluşturur.");
        expectedData=new HashMap<>();
        expectedData.put("countryCode",getCountryCode());
        expectedData.put("gsmNumber",getValidPhoneNumber());
        return this;
    }
    public AccountApi kullanici_sms_icin_request_gonderir_response_alir(){
        Allure.step("Kullanici sms almak için request gönderir response alir.");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(expectedData)
                .log().all()
                .when().post(getSignupApiUrl()+"/otp")
                .then().log().all().extract().response();
        return this;
    }
    public AccountApi kullanici_sms_dogrular_verificationNo_alir(){
        Allure.step("Kullanici gelen sms i doğrular ve verificationNo alir.");
        Assert.assertEquals(response.statusCode(),200);
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.getString("resultInfo.description"),getIslemBasariliMesaji());
        verificationNo=jsonPath.getInt("resultObject.verificationNo");
        return this;
    }
    public AccountApi kullanici_verify_icin_expected_data_olusturur(){
        Allure.step("Kullanici verify için expected data oluşturur.");
        expectedData.put("verificationNo",verificationNo);
        expectedData.put("verificationCode",getInvalidPassword());
        return this;
    }
    public AccountApi kullanici_verify_icin_request_gonderir_response_alir(){
        Allure.step("Kullanici verify için request gönderir response alir.");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(expectedData)
                .log().all()
                .when().post(getSignupApiUrl()+"/otp/verify")
                .then().log().all().extract().response();
        return this;
    }
    public AccountApi kullanici_verify_icin_dogrulama_yapar(){
        Allure.step("Kullanici verify için doğrulama yapar.");
        Assert.assertEquals(response.statusCode(),200);
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonPath.getString("resultObject.description"),getBilgilerHataliGirilmistirMesaji());
        return this;
    }
}
