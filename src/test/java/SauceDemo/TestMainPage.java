package SauceDemo;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



@Listeners(AutomationListenersWithScreenshots.class)
public class TestMainPage extends BaseDemo {





    @Test(description = "Title of the pagee",priority = 1)
    @Description("This test verify the the title of the page")
    public void titleofthepage(){
        String logintitle= driver.getTitle();
        System.out.println(logintitle);
        Assert.assertEquals(logintitle,"Swag Labs");
    }

        @Test(description = "Test - login to the site" ,priority = 2)
        @Description("This test fill the username and the password")
        public void logintosite() {
            login.logintosite("standard_user", "secret_sauce");

        }

        @Test(description = "check all the error fields and try to get in to the site with error user",priority = 2)
        public void errorfeildsmainpage(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        login.logintosite("locked_out_user","secret_sauce");
        String lockout = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(lockout,"Epic sadface: Sorry, this user has been locked out.");
        WebElement cleanfieldeusername = driver.findElement(By.id("user-name"));
        cleanfieldeusername.clear();
        WebElement cleanpassword = driver.findElement(By.xpath("//input[@data-test='password']"));
        cleanpassword.clear();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.xpath("//input[@data-test='password']")).isDisplayed();
        driver.findElement(By.id("login-button")).click();
        String problemuser = driver.findElement(By.cssSelector("img[class='inventory_item_img']")).getTagName();
        Assert.assertEquals(problemuser,"img");

        }


        @Test(description = "Test - page of products" ,priority = 3)
        @Description("This test fill the cart with products")
        public void productspage() {
            login.logintosite("standard_user", "secret_sauce");
            productsPage.clicktosort();
            productsPage.selectsort("lohi");
            productsPage.chechallthelowthinks();
            productsPage.next();
        }

            @Test(description = "Test - page of checkout" ,priority = 4)
            @Description("This test fill a form")
            public void checkoutpage() {
         login.logintosite("standard_user", "secret_sauce");
        productsPage.pickup();
        productsPage.setClickgotopaymant();
        productsPage.setCheckout();
        checkoutinfo.checkoutpage("michal", "ezer", "007");
        overview.totalprices();
        overview.finishpage();
        thanks.thankspage();

            }
    }



