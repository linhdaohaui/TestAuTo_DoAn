package Common;

import io.qameta.allure.Attachment;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ExtentManager {
    public WebDriver driver;

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    //Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    //Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

//    @Override
//    public void onStart(ITestContext iTestContext) {
//        driver = Constant.getDriver();
//        Log.info("Start testing " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", driver);
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        Log.info("End testing " + iTestContext.getName());
//        //Kết thúc và thực thi Extents Report
//        getExtentReports().flush();
//    }
//
//    @Override
//    public void onTestStart(ITestResult iTestResult) {
//        Log.info(getTestName(iTestResult) + " test is starting...");
//        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
//    }
}
