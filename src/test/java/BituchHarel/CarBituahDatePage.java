package BituchHarel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarBituahDatePage {

    @FindBy(id = "todayButton")
    private WebElement currentDayButton;

    @FindBy(id = "startDate")
    private WebElement dateElement;

    @Step("Click on Current Day Button to generate date")
    public void clickOnCurrentDayButton(){
        currentDayButton.click();
    }
    @Step("Print generate date and return it for later user")
     public String getDate(){
       String date = dateElement.getAttribute("value");
       System.out.println("Date is: "+date);
       return date;
    }

}
