package BituchHarel;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Base {
   public static WebDriver driver;
   public static  CarBituahPage carBituahPage;
   public static  CarFormPage carFormPage;
   public static  CarBituahDatePage carBituahDatePage;

    @BeforeClass
    public void startSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://digital.harel-group.co.il/car-purchase/v2/?utm_source=website&utm_medium=lobby&utm_content=cta_lobby&utm_campaign=kidom_car_insurance");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Init Page Objects:
        carBituahPage = PageFactory.initElements(driver, CarBituahPage.class);
        carFormPage = PageFactory.initElements(driver, CarFormPage.class);
        carBituahDatePage = PageFactory.initElements(driver, CarBituahDatePage.class);
    }

    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }


}
