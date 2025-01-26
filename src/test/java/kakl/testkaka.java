package kakl;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(AutomationListenersWithScreenshots.class)
    public class testkaka  extends MainPageKkl{

    @Test
    public void test01() throws InterruptedException {

        search.button.click();
        search.text.sendKeys("פלמחים");
        search.clickit.click();

        result.results.getText();
        result.clicktocontact.click();
        System.out.println(result.results.getText());
        contact.callplace.click();
        contact.name.sendKeys("רומי");
        contact.email.sendKeys("mic@mic.com");
        contact.phonum.sendKeys("0585177777");
        contact.subject.sendKeys("האם הצלחתי ");
        contact.extratext.sendKeys("יכול להיות");
        contact.chechbox.click();
        // Thread.sleep(30000);
        contact.policy.click();
        policy.polisyspage.getText();
        System.out.println(policy.polisyspage.getText());

        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.switchTo().window(originalWindow);


        WebElement elem = driver.findElement(By.id("ctl01"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }}



