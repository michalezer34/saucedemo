package BituchHarel;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AutomationListenersWithScreenshots.class)
public class TestCarBituah extends Base{


    @Test(description = "Test - Verify Date Picker")
    @Description("This test fill a form and click on date then verify it is equal to current date")
    public void test01VerifyDate(){
            carBituahPage.clickOnGetOffer();

            carFormPage.fillForm("Saed","Jaber","0525667481","181818");
            carFormPage.submitForm();
            carBituahDatePage.clickOnCurrentDayButton();

            String actualDate = carBituahDatePage.getDate();
            Assert.assertEquals(actualDate,"28/09/2024");

    }



}
