package constants;

import utils.ConfigurationReaderFile;

public class FrameworkConstants {
    private FrameworkConstants() {
    }

    private final static String HOMEPAGE_URL=ConfigurationReaderFile.get("homePageURL");
    private final static String INVALID_PHONE=ConfigurationReaderFile.get("invalidPhoneNumber");
    private final static String INVALID_PASSWORD=ConfigurationReaderFile.get("invalidPassword");
    private final static String VALID_NAME=ConfigurationReaderFile.get("validName");
    private final static String VALID_EMAIL=ConfigurationReaderFile.get("validEmail");
    private final static String VALID_SURNAME=ConfigurationReaderFile.get("validSurName");
    private final static String VALID_PHONE_NUMBER=ConfigurationReaderFile.get("validPhoneNumber");
    private final static String UYARI_MESSAGE2="Girdiğiniz onay kodu hatalıdır.";
    private final static String UYARI_MESSAGE="Hatalı bilgi girişi yaptınız.";
    private final static String SIGNIN_API_URL=ConfigurationReaderFile.get("signinApiURL");
    private final static String SIGNUP_API_URL=ConfigurationReaderFile.get("signupApiURL");
    private final static String HEROKU_API_URL=ConfigurationReaderFile.get("herokuApiURL");
    private final static String COUNTRY_CODE="+90";
    private final static String UYARI_MESSAGE3="İşlem Başarılı";
    private final static String UYARI_MESSAGE4="Bilgiler hatalı girilmiştir.";

    public static String getHomePageUrl(){
        return HOMEPAGE_URL;
    }
    public static String getInvalidPhoneNumber(){
        return INVALID_PHONE;
    }
    public static String getInvalidPassword(){
        return INVALID_PASSWORD;
    }
    public static String getValidName(){
        return VALID_NAME;
    }
    public static String getValidEmail(){
        return VALID_EMAIL;
    }
    public static String getValidSurName(){
        return VALID_SURNAME;
    }
    public static String getValidPhoneNumber(){
        return VALID_PHONE_NUMBER;
    }
    public static String getGirdiginizOnayKoduHatalidirMesaji(){
        return UYARI_MESSAGE2;
    }
    public static String getHataliBilgiGirisiYaptinizMesaji(){
        return UYARI_MESSAGE;
    }
    public static String getSigninApiUrl(){
    return SIGNIN_API_URL;
    }
    public static String getSignupApiUrl(){
        return SIGNUP_API_URL;
    }
    public static String getCountryCode(){
        return COUNTRY_CODE;
    }
    public static String getIslemBasariliMesaji(){
        return UYARI_MESSAGE3;
    }
    public static String getBilgilerHataliGirilmistirMesaji(){
        return UYARI_MESSAGE4;
    }
    public static String getHerokuApiUrl(){
        return HEROKU_API_URL;
    }
}
