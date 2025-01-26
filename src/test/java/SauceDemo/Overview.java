package SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Overview {

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalprice;
    @FindBy (xpath = "//button[@id='finish']")
    private WebElement finish;

     public void totalprices() {
        String totalpricealltheitem = totalprice.getText().trim();
        String expectedtotal = "Total: $32.39";
        Assert.assertEquals(totalpricealltheitem,expectedtotal);
       System.out.println("The total price is : "+ totalpricealltheitem);

   }



    public void finishpage(){
        finish.click();
    }

}
