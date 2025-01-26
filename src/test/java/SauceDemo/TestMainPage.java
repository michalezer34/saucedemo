package SauceDemo;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AutomationListenersWithScreenshots.class)
public class TestMainPage extends BaseDemo {




    @Test(description = "Title of the pagee",priority = 1)
    @Description("This test verify the the title of the page")
    public void titleofthepage(){
        String logintitle= driver.getTitle();
        System.out.println(logintitle);
        Assert.assertEquals(logintitle,"Swag Labs");
    }

        @Test(description = "Test - login to the site" ,priority = 2)
        @Description("This test fill the username and the password")
        public void logintosite() {
            login.logintosite("standard_user", "secret_sauce");

        }

        @Test(description = "Test - page of products" ,priority = 3)
        @Description("This test fill the cart with products")
        public void productspage() {
            login.logintosite("standard_user", "secret_sauce");
            productsPage.clicktosort();
            productsPage.selectsort("lohi");
            productsPage.chechallthelowthinks();
            productsPage.next();
        }

            @Test(description = "Test - page of checkout" ,priority = 4)
            @Description("This test fill a form")
            public void checkoutpage() {
         login.logintosite("standard_user", "secret_sauce");
        productsPage.pickup();
        productsPage.setClickgotopaymant();
        productsPage.setCheckout();
        checkoutinfo.checkoutpage("michal", "ezer", "007");
        overview.totalprices();
        overview.finishpage();
        thanks.thankspage();

            }
    }



