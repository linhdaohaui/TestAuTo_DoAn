package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;
import Interface.InterfaceManagerCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCart {

    private static WebDriver driver;
    String productId;
    String xpath_txt_qty;
    String xpath_bt_cart;
    int index = 2;
    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        InterfaceLogin.login(driver, Constant.email, Constant.password, "");
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']")).click();
        driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/h2[1]")).click();
        productId = InterfaceManagerCart.getProductByIndex(driver, index);
        WebElement productLink = driver.findElement(By.xpath("(//div[@class='product-item'])[" + index + "]//a"));
        productLink.click();
        xpath_txt_qty = InterfaceManagerCart.getXpathQuantityInput(productId);
        xpath_bt_cart  = InterfaceManagerCart.getXpathAddToCartButton(productId);
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
    @Test
    public void Test01() throws Exception {
        CommonFunction.clickItem(driver,xpath_bt_cart);
        CommonFunction.checkAlertAndAccept(driver, InterfaceManagerCart.succ_mess);
    }
    @Test
    public void Test02() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"2",InterfaceManagerCart.succ_mess);
    }
    @Test
    public void Test03() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"abc",InterfaceManagerCart.eror_mess);
    }
    @Test
    public void Test04() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"!@#",InterfaceManagerCart.eror_mess);
    }
    // file này kiểm tra cắt giá trị đầu cuối cho pass
    @Test
    public void Test05() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"    2    ",InterfaceManagerCart.succ_mess);
    }
    @Test
    public void Test06() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"",InterfaceManagerCart.eror_mess);
    }
    @Test
    public void Test07() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"        ",InterfaceManagerCart.eror_mess);
        System.out.println(driver.findElement(By.xpath(InterfaceManagerCart.xpath_noti_content)).getText());
    }
    @Test
    public void Test08() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"-1",InterfaceManagerCart.eror_mess );
    }
    public void Test09() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"0",InterfaceManagerCart.eror_mess );
    }
    public void Test10() throws Exception {
        InterfaceManagerCart.validatePositiveNumber(driver,xpath_txt_qty,xpath_bt_cart,"1.2",InterfaceManagerCart.eror_mess );
    }
}
