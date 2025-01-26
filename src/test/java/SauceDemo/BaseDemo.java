package SauceDemo;


import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseDemo {

    public static WebDriver driver;
    static MainPage login ;

    static ProductsPage productsPage;
    static Checkoutinfo checkoutinfo;
    static Overview overview;
    static Thanks thanks;


 @BeforeSuite

 public void BaseDemo() {
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://www.saucedemo.com/");
     login = PageFactory.initElements(driver,MainPage.class);
     productsPage=PageFactory.initElements(driver, ProductsPage.class);
     checkoutinfo=PageFactory.initElements(driver, Checkoutinfo.class);
     overview=PageFactory.initElements(driver, Overview.class);
     thanks=PageFactory.initElements(driver, Thanks.class);



 }

        @AfterSuite
    public void closesession(){
            Uninterruptibles.sleepUninterruptibly(5,TimeUnit.SECONDS);

        }

}
