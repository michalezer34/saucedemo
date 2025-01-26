package Lesson15;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PizzaOrderPage {
    WebDriver driver;

    public PizzaOrderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[@class='ginput_total ginput_total_5']")
    private WebElement totalPriceElement;

    @FindBy(id = "input_5_22_3")
    private WebElement firstNameField;

    @FindBy(id = "input_5_22_6")
    private WebElement lastNameField;

    @FindBy(id="input_5_21")
    private WebElement deliverySelectorElement;

    @FindBy(xpath = "//iframe[@src='coupon.html']")
    private WebElement iFrameContainer;

    @FindBy(id = "coupon_Number")
    private WebElement couponElement;

    @FindBy(name="input_20")
    private  WebElement enterCouponField;

    @FindBy(id="gform_submit_button_5")
    private  WebElement submitButton;

    @Step("Get current price")
    public String getTotalPrice(){
        String total = totalPriceElement.getText();
        CommonOps.logToReport("Current Price:"+total);
        return total;
    }

    @Step("Enter name and last name")
    public void enterDetails(String name,String lastName){
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
    }

    @Step("Select deliver by value")
    public void selectDeliveryByValue(String value){
        Select mySelector = new Select(deliverySelectorElement);
        mySelector.selectByValue(value);
    }

    @Step("Enter coupon")
    public String getCoupon(){
        driver.switchTo().frame(iFrameContainer);//Enter Iframe
        String myCoupon = couponElement.getText();
        driver.switchTo().defaultContent();//Exit Iframe
        CommonOps.logToReport("Coupon is: "+myCoupon);
        return myCoupon;
    }


    @Step("Enter coupon")
    public void enterCoupon(String coupon){
        enterCouponField.sendKeys(coupon);
    }

    @Step("Submit Order:")
    public void submitOrder(){
        submitButton.click();
    }

    @Step("Get Recipe")
    public String getReceipt(){
      Alert popup =  driver.switchTo().alert();
      String receipt =  popup.getText();
      popup.accept();
      CommonOps.logToReport("Receipt is: "+receipt);
      return receipt;
    }


}
