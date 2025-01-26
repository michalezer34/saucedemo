package SauceDemo;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class MainPage  {


        @FindBy (xpath = "//input[@id='user-name']")
                private WebElement clickusername;

        @FindBy(xpath = "//input[@id='user-name']")
        private WebElement sendusername;

        @FindBy (xpath = "//input[@id='password']")
        private WebElement clickpass;

        @FindBy(xpath ="//input[@id='password']")
                private WebElement sendpass;

        @FindBy(xpath ="//input[@name='login-button']" )
        private WebElement clicklogin;




    public void logintosite(String username ,String passward) {
            clickusername.click();
            sendusername.sendKeys(username);
            clickpass.click();
            sendpass.sendKeys(passward);
            clicklogin.click();

    }


}
