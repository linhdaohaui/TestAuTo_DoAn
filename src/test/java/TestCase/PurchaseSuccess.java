package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;
import Interface.InterfacePurchase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseSuccess {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        InterfaceLogin.login(driver, Constant.email, Constant.password, "");
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
        driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
        CommonFunction.clickItem(driver, InterfacePurchase.xpath_btn_termOfService);
        CommonFunction.clickItem(driver, InterfacePurchase.xpath_btn_purchase);
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        CommonFunction.screenShot(result);
    }
    @Test
    public void Test03(){
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_billingAd)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_acc)).isDisplayed();
    }
    @Test
    public void Test04(){
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_billingAd)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_shipAd)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_shipMed)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_payMed)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_btn_payInfor)).click();
        driver.findElement(By.xpath(InterfacePurchase.xpath_confirmOrder)).click();
        driver.findElement(By.xpath(InterfacePurchase.mess_purchase_success)).isDisplayed();
    }
}
