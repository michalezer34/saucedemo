package SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkoutinfo {
    @FindBy(xpath = "// input[@id='first-name']")
    private WebElement firstname;
    @FindBy(id = "last-name")
    private WebElement lastname;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalclick;

    @FindBy(xpath = "//input[@name='postalCode']")
    private WebElement postal;

    @FindBy(xpath = "//input[@name='continue']")
    private WebElement contin;


    public void checkoutpage(String entername,String enterlastname,String enternum){
        firstname.sendKeys(entername);
        lastname.sendKeys(enterlastname);
        postalclick.click();
        postal.sendKeys(enternum);
        contin.click();


    }
}
