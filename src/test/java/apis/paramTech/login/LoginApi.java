package apis.paramTech.login;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static constants.FrameworkConstants.*;

public class LoginApi {

    PayloadLoginPojo expectedData;
    Response response;

    public LoginApi kullanici_login_icin_expected_data_olusturur(){
        Allure.step("Kullanici login için expected data oluşturur.");
        expectedData=new PayloadLoginPojo();
        expectedData.setCountryCode(getCountryCode());
        expectedData.setUserGsmOrCardOrTCKN(getInvalidPhoneNumber());
        expectedData.setUserPassword(getInvalidPassword());
        return this;
    }
    public LoginApi kullanici_login_icin_request_gonderir_response_alir(){
        Allure.step("Kullanici login için request gönderir response alir.");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(expectedData)
                .log().all()
                .when().post(getSigninApiUrl())
                .then().log().all().extract().response();
        return this;
    }
    public LoginApi kullanici_giris_yapilamadigini_dogrular(){
        Allure.step("Kullanici giriş yapilamadiğini doğrular.");
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(jsonPath.getString("resultInfo.isSuccess"),"false");
        return this;
    }
}
