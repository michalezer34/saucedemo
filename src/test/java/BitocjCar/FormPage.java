package BitocjCar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage {
    @FindBy ( xpath = "//input[@id='input_firstname']")
    public WebElement firstname;

    @FindBy ( xpath = "//input[@id='input_lastname']")
    public WebElement lastname;

    @FindBy (xpath = "//input[@id='input_id']")
    public WebElement id;

    @FindBy ( xpath = "//input[@id='input_phone']")
    public WebElement phonenum;

    @FindBy  (xpath = "//button[@CLASS='btn btn-orange']")
    public WebElement clickbutton;

    public void feilds (String firstnamefeild , String lastnamefeild , String idfeild , String phonefeild ){
        firstname.sendKeys(firstnamefeild);
        lastname.sendKeys(lastnamefeild);
        id.sendKeys(idfeild);
        phonenum.sendKeys(phonefeild);


    }
    public void clickform() {
        clickbutton.click();
    }




}
