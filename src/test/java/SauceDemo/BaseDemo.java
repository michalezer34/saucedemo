package SauceDemo;


import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseDemo {

    public static WebDriver driver;
    static MainPage login ;

    static ProductsPage productsPage;
    static Checkoutinfo checkoutinfo;
    static Overview overview;
    static Thanks thanks;


 @BeforeMethod


 public void BaseDemo() {
     WebDriverManager.chromedriver().setup();

     // הגדרת העדפות כרום
     Map<String, Object> prefs = new HashMap<>();
     prefs.put("credentials_enable_service", false);
     prefs.put("profile.password_manager_enabled", false);

     ChromeOptions options = new ChromeOptions();
     options.setExperimentalOption("prefs", prefs);
     options.addArguments("--disable-notifications");
     options.addArguments("--disable-popup-blocking");
     options.addArguments("--incognito"); // מצב גלישה בסתר

     // יצירת הדרייבר עם ההגדרות
     driver = new ChromeDriver(options);

     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://www.saucedemo.com/");

     // אתחול עמודים
     login = PageFactory.initElements(driver, MainPage.class);
     productsPage = PageFactory.initElements(driver, ProductsPage.class);
     checkoutinfo = PageFactory.initElements(driver, Checkoutinfo.class);
     overview = PageFactory.initElements(driver, Overview.class);
     thanks = PageFactory.initElements(driver, Thanks.class);
 }
        @AfterMethod
    public void closesession(){
            Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        }
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }}
        }
