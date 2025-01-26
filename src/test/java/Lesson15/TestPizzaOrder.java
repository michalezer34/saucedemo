package Lesson15;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AutomationListenersWithScreenshots.class)
public class TestPizzaOrder extends GlobalBase {
    final String firstName= "Saed";
    final String lastName = "Jaber";

    @Test(description = "Test01 - Verify inital price")
    @Description("This test verify the initial price is as expected without delivery")
    public void test01VerifyInitialPrice(){
       String initialPrice= orderPage.getTotalPrice();
       Assert.assertEquals(initialPrice,"$7.50");
    }

    @Test(description = "Test02 - Verify Price with delivery")
    @Description("This test verify price after adding delivery")
    public void test02VerifyPriceWithDelivery(){
        orderPage.selectDeliveryByValue("Delivery|3");
        String updatedPrice= orderPage.getTotalPrice();
        Assert.assertEquals(updatedPrice,"$10.50");
    }
    @Test(description = "Test03 - Verify Coupon")
    @Description("This test verify coupon is inserted correctly")
    public void test03VerifyCoupon(){
        orderPage.enterDetails(firstName,lastName);
        String coupon = orderPage.getCoupon();
        orderPage.enterCoupon(coupon);
        orderPage.submitOrder();
        String actualReceipt = orderPage.getReceipt();
        String expectedReceipt = firstName+" "+lastName+" "+coupon;
        Assert.assertEquals(actualReceipt,expectedReceipt);
    }

}
