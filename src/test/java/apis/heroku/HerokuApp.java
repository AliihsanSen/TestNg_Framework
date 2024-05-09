package apis.heroku;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import static constants.FrameworkConstants.*;

import java.util.HashMap;
import java.util.Map;

public class HerokuApp {

    Response response;
    public static PayloadPojo expectedData;
    int bookingid;
    String token;

    public HerokuApp kullanici_kayit_icin_expected_data_olusturur(){
        Allure.step("Kullanici kayit için expected data oluşturur.");
        expectedData=new PayloadPojo();
        PayloadBookingdatesPojo bookingdatesPojo = new PayloadBookingdatesPojo();

        expectedData.setFirstname(getValidName());
        expectedData.setLastname(getValidSurName());
        expectedData.setTotalprice(111);
        expectedData.setDepositpaid(true);
        expectedData.setAdditionalneeds("Breakfast");
        bookingdatesPojo.setCheckin("2024-03-03");
        bookingdatesPojo.setCheckout("2024-03-05");
        expectedData.setBookingdates(bookingdatesPojo);
        return this;
    }
    public HerokuApp kullanici_kayit_icin_request_gonderir_response_alir(){
        Allure.step("Kullanici kayit için request gönderir response alir.");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(expectedData)
                .log().all()
                .when().post(getHerokuApiUrl()+"/booking")
                .then().log().all().extract().response();
        return this;
    }
    public HerokuApp kullanici_kayit_isleminin_dogrulamasini_yapar(){
        Allure.step("Kullanici kayit isleminin doğrulamasını yapar.");
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(jsonPath.getString("booking.firstname"),expectedData.getFirstname());
        bookingid=jsonPath.getInt("bookingid");
        return this;
    }
    public HerokuApp kullanici_login_gerceklestirir_token_alir(){
        Allure.step("Kullanici login gerceklestirir token alir.");
        Map<String,String> loginExpectedData=new HashMap<>();
        loginExpectedData.put("username","admin");
        loginExpectedData.put("password","password123");
        Response loginResponse=RestAssured.given()
                .header("Content-Type", "application/json")
                .body(loginExpectedData)
                .log().all()
                .when().post(getHerokuApiUrl()+"/auth")
                .then().log().all().extract().response();

        Map<String,String>actualDataLogin=loginResponse.as(HashMap.class);
        Assert.assertEquals(loginResponse.statusCode(),200);
        token=actualDataLogin.get("token");
        Assert.assertTrue(!token.isEmpty());
        return this;
    }
    public HerokuApp kullanici_olusturdugu_kaydi_siler_ve_dogrular(){
        Allure.step("Kullanici olusturdugu kaydi siler ve dogrular.");
        response=RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Cookie", "token="+token)
                .log().all()
                .when().delete(getHerokuApiUrl()+"/booking/"+bookingid)
                .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(),201);
        return this;
    }
}
