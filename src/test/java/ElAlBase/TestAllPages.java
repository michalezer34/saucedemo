package ElAlBase;

import SauceDemo.AutomationListenersWithScreenshots;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.swing.*;

@Listeners(AutomationListenersWithScreenshots.class)

public class TestAllPages extends BaseElAl{
    @Test(description = "Test - login to the site" ,priority = 2)
    @Description("This test fill the username and the password")
    public void logintosite() {
        driver.get("https://www.elal.com/heb/about-elal/contact-us");
        driver.findElement(By.xpath("//a[contains(text(), 'מועדון הנוסע המתמיד')]")).click();
        driver.switchTo().frame(0);
        System.out.println(driver.getPageSource()+ " הראשון**** ");




        WebElement movetoelem = driver.findElement(By.xpath("//a[contains(text(), 'כניסה לחשבון שלי')]"));
        Actions action = new Actions(driver) ;
        action.moveToElement(movetoelem).click().perform();


        System.out.println(driver.getPageSource()+"השני*****");
        driver.switchTo().frame(0);
        driver.findElement(By.id("ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_MembertxtID")).sendKeys("103524849");
        driver.findElement(By.id("ctl00_SPWebPartManager1_g_6b4d7b7c_75d5_444a_9433_d3b17a3e6f47_ctl00_PasswordtxtID")).sendKeys("Me36046639");
        driver.switchTo().defaultContent();
    }
}
