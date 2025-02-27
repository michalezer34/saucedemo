package SauceDemo;

import ElAlBase.BaseElAl;
import Lesson15.CommonOps;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AutomationListenersWithScreenshots extends BaseDemo implements ITestListener
{
    public void onStart(ITestContext execution) {
        CommonOps.logToReport("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        CommonOps.logToReport("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        CommonOps.logToReport("---------------------- Test: " + test.getName() + " Started ------------------");
    }

    public void onTestSuccess(ITestResult test) {
        CommonOps.logToReport("---------------------- Test: " + test.getName() + " Passed ------------------");
    }

    public void onTestFailure(ITestResult test) {
        CommonOps.logToReport("---------------------- Test "  + test.getName() + " Failed ------------------");
        saveScreenshot();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        // TODO Auto-generated method stub
    }

    @Attachment(value="Page Screenshot",type = "image/png")
    public byte[] saveScreenshot(){
        System.out.println("TAKING SCREENSHOTS!!!");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}
