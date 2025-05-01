package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceForgotPassword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertEquals;

public class ForgotPassword {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        WebElement find_forgot = driver.findElement(By.xpath("//a[normalize-space()='Forgot password?']"));
        find_forgot.click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }
    //Test 01 mail đã được đăng kí
    @Test
    public void Test_01() throws Exception {
        InterfaceForgotPassword.forgotFass(driver , Constant.email, InterfaceForgotPassword.mess_success);
    }
    // Test 02 mail chưa được đăng kí
    @Test
    public void Test_02() throws Exception {
        InterfaceForgotPassword.forgotFass(driver, "mcajsgfvhasg@gmil.com", InterfaceForgotPassword.messs_error_find);
    }


    //Test 03 Kiểm tra trường mail rỗng

    @Test
    public void Test_03() throws Exception {
        InterfaceForgotPassword.forgotFass(driver, "", InterfaceForgotPassword.mess_error_email_empty);
    }

    //Test 04 Kiểm tra email không đúng dịnh dạng
    @Test
    public void Test_04() throws Exception {
        InterfaceForgotPassword.forgotFass(driver, "linh", InterfaceForgotPassword.mess_error_email_val);
    }
    //Kiểm tra mail chưa khoảng trắng ở trước và sau
    @Test
    public void Test_05() throws Exception {
        InterfaceForgotPassword.forgotFass(driver, "   " + Constant.email + "   ", InterfaceForgotPassword.mess_success);
    }



}
