package SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Thanks {
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement thanks;

    public void thankspage(){
        thanks.getText();
    }
}
