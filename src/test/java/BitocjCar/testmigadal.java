package BitocjCar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (AutomationListenersWithScreenshots.class)
public class testmigadal extends MainPage {

    @Test
    public void testLoginClick() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        // שימוש במשתנה הגלובלי loginPage כדי לבצע פעולות
        loginp.loginpage.click();
        formPage.feilds("עזר","מיכל","036046639","0505938333");
        formPage.clickform();

        WebElement carnum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='number']")));
        nnumcar.carnum("115-15-151");
        nnumcar.checbox.click();
        nnumcar.butnfoword.click();

    }


}
