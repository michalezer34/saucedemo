package BitocjCar;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Numcar {
    @FindBy (xpath = "//input[@name='number']")
    public WebElement carnum;

    @FindBy(xpath = "//label[@role='checkbox']")
    public WebElement checbox;

    @FindBy (xpath = "//button[@class='btn']")
    public WebElement butnfoword;




    public void carnum(String carnumfeild ){
        carnum.sendKeys(carnumfeild);
    }
    public void numclick(){
        checbox.click();
        butnfoword.click();

    }


}
