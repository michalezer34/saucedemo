package ElAlBase;

import SauceDemo.MainPage;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;
public class BaseElAl {

    public static WebDriver driver;
    static LoginPage login ;
    @BeforeSuite
        public void BaseElAl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://matmid.elal.com/he/Login/Pages/Login.aspx");
        login = PageFactory.initElements(driver, LoginPage.class);
        }
    @AfterSuite
    public void closesession(){
        Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

    }
    }




