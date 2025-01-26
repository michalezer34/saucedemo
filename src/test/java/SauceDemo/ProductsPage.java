package SauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class ProductsPage {
    @FindBy (xpath = "//select[@class='product_sort_container']")
   private WebElement sort;

    @FindBy (xpath = "//select[@class='product_sort_container']")
    private WebElement sortlowprice;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    private WebElement backpack;

    @FindBy(xpath = "// div[@class='inventory_item_price']")
    private List<WebElement> allprices;

    @FindBy(xpath = "// div[@class='pricebar']/button")
    private List<WebElement> buttonaddtocart;

    @FindBy(xpath = "// a[@class='shopping_cart_link']")
    private WebElement cart;

    @FindBy(xpath = "//span[text()='5']")
    private WebElement iteminthecart;

    @FindBy(xpath = "// button[@name='checkout']")
    private WebElement checkout;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement pickupitem;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickgotopaymant;

    public void clicktosort(){
        sort.click();
    }
    public void selectsort (String value) {

        Select myselector = new Select(sortlowprice);
        myselector.selectByValue(value);
    }



    public void chechallthelowthinks() {

        // משתמשים באורך של buttonaddtocart כדי למנוע חריגה
        for (int i = 0; i < buttonaddtocart.size(); i++) {
            String priceText = allprices.get(i).getText();
            double productPrices = Double.parseDouble(priceText.replace("$", ""));
            System.out.println("Total items in allprices: " + allprices.size());
            System.out.println("Total items in buttonaddtocart: " + buttonaddtocart.size());

            if (productPrices < 30.99) {
                System.out.println("Adding item with price " + productPrices + " to cart.");
                // לחיצה על כפתור הוספה לעגלה של הפריט הנוכחי
                buttonaddtocart.get(i).click();
            } else {
                System.out.println("Item with price " + productPrices + " is $30 or more. Not adding to cart.");
            }
        }
    }


    public void next () {
            cart.click();
        String itemsonthecart = iteminthecart.getText();
        System.out.println(itemsonthecart);
        Assert.assertEquals(itemsonthecart, "5");
            checkout.click();
        }
        public void setCheckout(){
            checkout.click();
        }


        public void pickup(){
        pickupitem.click();
        }

        public void setClickgotopaymant(){
        clickgotopaymant.click();
        }



    }


