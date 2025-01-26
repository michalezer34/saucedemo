package BituchHarel;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarFormPage {

    @FindBy(id="firstName")
    private WebElement firstNameField;

    @FindBy(css = "input[id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='mobileNumber']")
    private WebElement phoneField;

    @FindBy(css = "input[aria-labelledby='id-label']")
    private WebElement idField;

    @FindBy (id="disclaimer")
    private WebElement disclaimerBox;

    @FindBy (id="submitButton")
    private WebElement submitButton;


    @Step("Filling Form:")
    public void fillForm(String firstName, String lastName,String mobile,String id){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        phoneField.sendKeys(mobile);
        idField.sendKeys(id);
        disclaimerBox.click();
    }
    @Step("Submit Form:")
    public void submitForm(){
        submitButton.click();
    }

}
