package BitocjCar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "(//strong[@class='migdal-color-3c65e3'])[2]")
    public WebElement loginpage;

    public void loginp() {

        loginpage.click();

    }
}
