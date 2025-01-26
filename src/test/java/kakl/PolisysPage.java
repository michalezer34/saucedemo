package kakl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolisysPage {
    @FindBy (xpath = "//h1[@class='page-title section-title']")
    public WebElement polisyspage;

    public void policiys() {

        polisyspage.getText();
    }


}