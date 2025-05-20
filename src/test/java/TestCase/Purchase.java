package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfacePurchase;
import Interface.InterfaceRegister;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Purchase {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
        driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        CommonFunction.screenShot(result);
    }
    @Step("Purchase_Test01")
    @Test
    public void Test_01() throws Exception {
        CommonFunction.clickItem(driver, InterfacePurchase.xpath_btn_purchase);
        driver.findElement(By.xpath(InterfacePurchase.xpath_dialog_term)).isDisplayed();
    }
    @Step("Purchase_Test02")
    @Test(dependsOnMethods = "Test_01")
    public void Test02() throws Exception {
        CommonFunction.clickItem(driver, InterfacePurchase.xpath_btn_termOfService);
        CommonFunction.clickItem(driver, InterfacePurchase.xpath_btn_purchase);
        driver.findElements(By.xpath(InterfacePurchase.xpath_content_sign_in));
    }
}
