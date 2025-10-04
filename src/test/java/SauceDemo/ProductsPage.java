package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;




public class ProductsPage {
    @FindBy (xpath = "//select[@class='product_sort_container']")
   private WebElement sort;

    @FindBy (xpath = "//select[@class='product_sort_container']")
    private WebElement sortLowPrice;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    private WebElement backpack;

    @FindBy(xpath = "// div[@class='inventory_item_price']")
    private List<WebElement> allPrices;

    @FindBy(xpath = "// div[@class='pricebar']/button")
    private List<WebElement> buttonAddToCart;

    @FindBy(xpath = "// a[@class='shopping_cart_link']")
    private WebElement cart;

    @FindBy(xpath = "//span[text()='5']")
    private WebElement itemInTheCart;

    @FindBy(xpath = "// button[@name='checkout']")
    private WebElement checkout;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement pickUpItem;

    @FindBy(css = "button[class='btn btn_primary btn_small btn_inventory ']")
    private WebElement fourProducts;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickGoToPayment;

    public void clickToSort(){
        sort.click();
    }
    public void selectSort(String value) {

        Select mySelector = new Select(sortLowPrice);
        mySelector.selectByValue(value);
    }

    public void checkAllTheLowThinks() {

        // משתמשים באורך של buttonAddToCart כדי למנוע חריגה
        for (int i = 0; i < buttonAddToCart.size(); i++) {
            String priceText = allPrices.get(i).getText();
            double productPrices = Double.parseDouble(priceText.replace("$", ""));
            System.out.println("Total items in allPrices: " + allPrices.size());
            System.out.println("Total items in buttonAddAoCart: " + buttonAddToCart.size());

            if (productPrices < 30.99) {
                System.out.println("Adding item with price " + productPrices + " to cart.");
                // לחיצה על כפתור הוספה לעגלה של הפריט הנוכחי
                buttonAddToCart.get(i).click();
            } else {
                System.out.println("Item with price " + productPrices + " is $30 or more. Not adding to cart.");
            }
        }
    }

    public void pickUpItems(){
        List<WebElement> buttons1 = fourProducts.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        for (WebElement button : buttons1) {
            button.click();
        }
    }


    public void next () {
            cart.click();
        String itemsOnTheCart = itemInTheCart.getText();
        System.out.println(itemsOnTheCart);
        Assert.assertEquals(itemsOnTheCart, "5");
            checkout.click();
        }
        public void setCheckout(){
            checkout.click();
        }
        public void pickup(){
        pickUpItem.click();
        }
        public void setClickGoToPayment(){
        clickGoToPayment.click();
        }

    }


