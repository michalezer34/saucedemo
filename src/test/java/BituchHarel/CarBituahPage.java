package BituchHarel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarBituahPage {

    @FindBy(id="mainButton")
    private WebElement offerButton;

    @Step("Click on get offer button")
    public void clickOnGetOffer(){
        offerButton.click();
    }

}
