package BitocjCar;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


public class MainPage {

    WebDriver driver;
    LoginPage loginp;
    FormPage formPage;

    Numcar nnumcar;



    @BeforeTest
    public void Test01() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.migdal.co.il/online");
        driver.getPageSource();
        driver.getWindowHandle();
        loginp = PageFactory.initElements(driver, LoginPage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
        nnumcar = PageFactory.initElements(driver, Numcar.class);


    }

    @AfterClass
    public void closeSession(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.quit();
    }


}