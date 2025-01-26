package kakl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {
    @FindBy (xpath = "//h1[@class='page-title section-title']")
    public WebElement results;

    @FindBy  (xpath = "//A[@class='page-header_contact-link']")
    public WebElement clicktocontact;

    public void resultpalmahim ( String gettext){
        results.getText();
        clicktocontact.click();

    }




}
