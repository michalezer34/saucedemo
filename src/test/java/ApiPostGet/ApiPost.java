package ApiPostGet;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;




public class ApiPost {
    String baseURL = "http://localhost:9000";
    public static RequestSpecification request;
    public static Response response;
    private WebDriver driver;


    @BeforeClass
    public void start() {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.filters( new RequestLoggingFilter(), new ResponseLoggingFilter());

    }





    @Test
    public void test01_noCourse() {

        JSONObject params = new JSONObject();
        params.put("firstName", "michal");
        params.put("lastName", "ezer");
        params.put("email", "mihalez@harel.com");
        params.put("programme", "tester");

        request.body(params.toJSONString());
        response = request.post("/student");

        response.prettyPrint();
        assertEquals(response.getStatusCode(), 201);

    }

    @Test
    public void test02_withCourses() {
        JSONObject params = new JSONObject();
        params.put("firstName", "gal");
        params.put("lastName", "meir");
        params.put("email", "michalz@harel.com");
        params.put("programme", "tester");

        // יצירת מערך של קורסים
        JSONArray courses = new JSONArray();
        courses.add("Python");
        courses.add("Java");
        courses.add("C++");

        // הוספת המערך ל-JSON של הבקשה
        params.put("courses", courses);

        request.body(params.toJSONString());
        response = request.post("/student");

        response.prettyPrint();
        assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void test03_deleteStudent() {
        int studentId = 100;  // מזהה התלמיד למחיקה

        // שליחת בקשת DELETE
        response = request.delete("/student/" + studentId);

        // הדפסת התגובה והווידוא שקוד התגובה הוא 204 (הצלחה ללא תוכן)
        response.prettyPrint();
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void test04_getStudentById() {

        // שליחת בקשת GET
        response = request.get("/student/list");

        // הדפסת התגובה והווידוא שקוד התגובה הוא 200 (הצלחה)
        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();

        // שליפת רשימות של שמות פרטיים, שמות משפחה ומיילים
        List<String> firstName = jsonPath.getList("firstName");
        List<String> lastNames = jsonPath.getList("lastName");
        List<String> emails = jsonPath.getList("email");


        // הדפסת המידע בשורה אחת עבור כל תלמיד
        for (int i = 0; i < firstName.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + firstName.get(i) + " " + lastNames.get(i) + " - " + emails.get(i));

        }
    }

        @Test
        public void test05_getStudentById () {
            // שליחת בקשת GET
            response = request.get("/student/1");

            // הדפסת התגובה והווידוא שקוד התגובה הוא 200 (הצלחה)
            response.prettyPrint();
            assertEquals(response.getStatusCode(), 200);

            JsonPath jsonPath = response.jsonPath();

            // שליפת המידע של התלמיד הבודד
            String firstName = jsonPath.getString("firstName");
            String lastName = jsonPath.getString("lastName");
            String email = jsonPath.getString("email");

            // הדפסת המידע בצורה יפה
            System.out.printf("Student Details:\n");
            System.out.printf("Name: %s %s\n", firstName, lastName);
            System.out.printf("Email: %s\n", email);
        }

    @Step("{0}")
    public void logToReport(String message) {
        System.out.println(message); //or System.out.println(message);
    }
}














