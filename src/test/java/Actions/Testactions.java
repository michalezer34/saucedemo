package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testactions {
    public static WebDriver driver;

    @BeforeClass

    public void BaseRami() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void test01() {
        //loginpagepage
        driver.findElement(By.xpath("//input[@id='user-name']")).click();
        driver.findElement(By.xpath(("//input[@id='user-name']"))).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@name='login-button']")).click();
        //productspage
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("// option [@value='lohi']")).click();
        driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]")).click();
        WebElement priceElement = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
        // קבלת המחיר כטקסט והמרה למספר
        String priceText = priceElement.getText().replace("$", "").trim(); // נניח שהמחיר מופיע כמו "$29.99"
        double price = Double.parseDouble(priceText);

        // בדוק אם המחיר קטן מ-30 דולר
        if (price < 30.0) {
            // לחיצה על כפתור ההוספה לעגלה
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
            addToCartButton.click();
            System.out.println("המוצר נוסף לעגלה.");
        } else {
            System.out.println("המוצר לא נוסף לעגלה - המחיר גבוה מ-30 דולר.");
            driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        }
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();


        driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Onesie')]")).click();
        WebElement priceElementOnesie = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
        // קבלת המחיר כטקסט והמרה למספר
        String priceTextOnesie = priceElementOnesie.getText().replace("$", "").trim(); // נניח שהמחיר מופיע כמו "$7.99"
        double priceOnesie = Double.parseDouble(priceText);

        // בדוק אם המחיר קטן מ-6 דולר
        if (price < 6.0) {
            // לחיצה על כפתור ההוספה לעגלה
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
            addToCartButton.click();
            System.out.println("המוצר נוסף לעגלה.");
        } else {
            System.out.println("המוצר לא נוסף לעגלה - המחיר גבוה מ-6 דולר.");
            driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        }
        driver.findElement(By.xpath("// span[@class='shopping_cart_badge']")).click();
        driver.findElement(By.xpath("// button[@name='checkout']")).click();
//paymentpage

        driver.findElement(By.xpath("// input[@id='first-name']")).sendKeys("michal");
        driver.findElement(By.id("last-name")).sendKeys("ezer");
        driver.findElement(By.xpath("//input[@id='postal-code']")).click();
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("007");
        driver.findElement(By.xpath("//input[@name='continue']")).click();
    }
//Payment Informationpage
        @Test()
        public void testFreeShipping() {
            boolean isFreeShippingAvailable;

            try {
                WebElement freeShippingElement = driver.findElement(By.xpath("//div[contains(text(), 'Free')]"));
                isFreeShippingAvailable = freeShippingElement.isDisplayed();
            } catch (NoSuchElementException e) {
                isFreeShippingAvailable = false; // קבע שאין משלוח חינם אם אין אלמנט
            }



        }
            @Test
            public void testCartTotal() {
                // מציאת סכום הפריט
                WebElement itemTotalElement = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
                String itemTotalText = itemTotalElement.getText().replace("Item total: $", "").trim();
                double itemTotal = Double.parseDouble(itemTotalText); // המרת המחרוזת למספר

                // מציאת סכום המס
                WebElement taxElement = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
                String taxText = taxElement.getText().replace("Tax: $", "").trim();
                double tax = Double.parseDouble(taxText); // המרת המחרוזת למספר

                // מציאת הסכום הכולל
                WebElement totalElement = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
                String totalText = totalElement.getText().replace("Total: $", "").trim();
                double total = Double.parseDouble(totalText); // המרת המחרוזת למספר

                double expectedTotal = itemTotal + tax;

                Assert.assertEquals(expectedTotal,total , "המחיר זהה");
                System.out.println(expectedTotal);
                System.out.println(total);

                driver.findElement(By.xpath("//button[@id='finish']")).click();

                //finishpage

                String actualText = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
// הדפסת הטקסט שנמצא באלמנט
                System.out.println("הטקסט שנמצא הוא: " + actualText);




            }
        }




