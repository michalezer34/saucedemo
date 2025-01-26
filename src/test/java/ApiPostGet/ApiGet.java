package ApiPostGet;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;

public class ApiGet {
    String baseURL = "http://localhost:9000";
    public static RequestSpecification request;
    public static Response response;

    // הוספת WebDriver
    private WebDriver driver;

    @BeforeClass
    public void start() {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");

    }

    @Test
    public void test04_getStudentById() {
        // שליחת בקשת GET
        response = request.get("/student/6");

        // הדפסת התגובה והווידוא שקוד התגובה הוא 200 (הצלחה)
        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();

        // שליפת המידע של התלמיד הבודד
        String firstName = jsonPath.getString("firstName");
        String lastName = jsonPath.getString("lastName");
        String email = jsonPath.getString("email");

        // הדפסת המידע לדו"ח אלוואר
       logToReport("firstName");


    }

    @Step("Logging student details")
    public void logStudentDetails(String firstName, String lastName, String email) {
        String studentDetails = String.format("Student Details: %s %s - %s", firstName, lastName, email);
        Allure.addAttachment("Student Info", studentDetails);
       logToReport(studentDetails); // להדפיס גם לקונסולה אם צריך
    }

    public void captureScreenshot() {
        // צילום המסך והוספתו לדו"ח
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
    }

    // ניהול של סגירת הדפדפן
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("{0}")
    public void logToReport(String message) {
        System.out.println(message); //or System.out.println(message);
    }

}

