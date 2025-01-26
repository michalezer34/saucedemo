package kakl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearcePage {
    @FindBy(xpath = "(//i[@class='site-search_icon'])[1]")
    public WebElement button;

    @FindBy(xpath  ="//input[@id='ctl07_ctlSearchText']")
    public WebElement text;


    @FindBy(xpath = "(//i[@class='site-search_icon'])[2]")
    public WebElement clickit;




    public void searchfirstpage( String searchvalue )
    {
        button.click();
        text.sendKeys(searchvalue);
        clickit.click();
    }


}