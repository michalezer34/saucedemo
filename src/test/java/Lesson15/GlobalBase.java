package Lesson15;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class GlobalBase {
   public static WebDriver driver;
   public static  PizzaOrderPage orderPage;
    @BeforeSuite
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://atidcollege.co.il/Xamples/pizza/");
        orderPage= new PizzaOrderPage(driver);
    }
    @AfterSuite
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        driver.quit();
    }
}
