package ApiOpenWeather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenWeatherMapEx {
    RequestSpecification httpRequest;
    //שולחת בקשה
    Response response;
    //ממתינה לתשובה
    SoftAssert soft;
    final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    final String CITY = "Jerusalem,IL";
    final String API_KEY = "ad48510a9aed1ff96b51557d94bc5964";
    //שינוי לצלזיוס
    final String UNITS = "metric";

    @BeforeClass
    public void startSession() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        //הרבה השוואות ולכן שמתי במשתנה
        soft = new SoftAssert();
    }

    @Test
    public void test01VerifyWeatherData() {
        response = httpRequest.get("?q=" + CITY + "&units=" + UNITS + "&appid=" + API_KEY);
        //מדפיס באופן יפה
        response.prettyPrint();
        //הדפסות של התוצאות שלי
        System.out.println("Status Line: " + response.statusLine());
        System.out.println("Response's Date:" + response.getHeader("Date"));
        System.out.println("Content-Type:" + response.contentType());
        System.out.println("Status Code: " + response.statusCode());
        soft.assertTrue(response.contentType().contains("json"));
        soft.assertEquals(response.statusCode(), 200);
        //בגלל שהשתמשתי בהרבה סופטאסרטט אני חייבת לכתוב את השורה זו האחרונה
        soft.assertAll();
    }
}