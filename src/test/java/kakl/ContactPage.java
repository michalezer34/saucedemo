package kakl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage {

    @FindBy (xpath = "//label[@for='MainPageContentPlaceHolder_SVSrvPrezZoneHolder0_ctl01_ctl11_1']")
    public WebElement callplace;

    @FindBy(xpath = "//input[@name='ctl00$ctl00$MainPageContentPlaceHolder$SVSrvPrezZoneHolder0$ctl01$ctl18']")
    public WebElement name;

    @FindBy (xpath = "//input[@name='ctl00$ctl00$MainPageContentPlaceHolder$SVSrvPrezZoneHolder0$ctl01$ctl25']")
    public WebElement email;

   @FindBy (xpath = "//input[@name='ctl00$ctl00$MainPageContentPlaceHolder$SVSrvPrezZoneHolder0$ctl01$ctl32']")
    public WebElement phonum;
    @FindBy (xpath = "//input[@name='ctl00$ctl00$MainPageContentPlaceHolder$SVSrvPrezZoneHolder0$ctl01$ctl39']")
    public WebElement subject;
   @FindBy (xpath = "//textarea[@name='ctl00$ctl00$MainPageContentPlaceHolder$SVSrvPrezZoneHolder0$ctl01$ctl46']")
    public WebElement extratext;
    @FindBy (xpath = "//label[@for='MainPageContentPlaceHolder_SVSrvPrezZoneHolder0_ctl01_ctl58']")
    public WebElement chechbox;
   @FindBy (xpath = "(//a[@target='_blank'])[12]")
    public WebElement policy;



    public void form ( String firstname , String micom ,String phone ,String somewords,String extera) {

        callplace.click();
        name.sendKeys(firstname);
        email.sendKeys(micom);
        phonum.sendKeys(phone);
        subject.sendKeys(somewords);
        extratext.sendKeys(extera);
        chechbox.click();
        policy.click();






    }

}
