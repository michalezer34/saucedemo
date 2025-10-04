package SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Overview {

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalprice;
    @FindBy (xpath = "//button[@id='finish']")
    private WebElement finish;

    @FindBy (css = "div[class='summary_subtotal_label']")
    private WebElement summary;

    @FindBy ( css = "div[class='summary_tax_label']")
    private WebElement tax;

     public void totalPrices() {
        String totalPriceAllTheItem = totalprice.getText().trim();
        String expectedTotal = "Total: $32.39";
        Assert.assertEquals(totalPriceAllTheItem,expectedTotal);
       System.out.println("The total price is : "+ totalPriceAllTheItem);

   }

   public void checkTheTax(){

       String itemTotalText = summary.getText().replace("Item total: $", "").trim();
       double itemTotal = Double.parseDouble(itemTotalText);
       double expectedTotal = itemTotal * 1.08008;
       expectedTotal = Math.round(expectedTotal * 100.0) / 100.0;

       String totalText = totalprice.getText().replace("Total: $", "").trim();
       double actualTotal = Double.parseDouble(totalText);

       Assert.assertEquals(actualTotal, expectedTotal, 0.01);

   }



    public void finishpage(){
        finish.click();
    }

}
