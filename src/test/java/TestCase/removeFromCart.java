package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;
import Interface.InterfaceManagerCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class removeFromCart {
    WebDriver driver;
    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        InterfaceLogin.login(driver, Constant.email, Constant.password, "");
        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        CommonFunction.shutDownDriver(driver);
    }
    /*
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        CommonFunction.screenShot(result);
    }
     */
    @Test()
    public void Test01() throws Exception {
        InterfaceManagerCart.removeItemByIndex(driver, 0);
    }
    @Test()
    public void Test02() throws Exception {
        InterfaceManagerCart.removeAllItemsFromCart(driver);
    }
}
