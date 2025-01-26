package kakl;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class MainPageKkl {
    static WebDriver driver;
    static SearcePage search;
    static ResultPage result;
    static  ContactPage contact;
    static  PolisysPage policy;


    @BeforeTest
    public void Test01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.kkl.org.il/travel/");
        search = PageFactory.initElements(driver, SearcePage.class);
        result = PageFactory.initElements(driver, ResultPage.class);
        contact = PageFactory.initElements(driver, ContactPage.class);
        policy = PageFactory.initElements(driver, PolisysPage.class);
    }
    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }


}







