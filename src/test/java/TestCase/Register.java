package TestCase;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceRegister;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Register {
    private static WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        CommonFunction.shutDownDriver(driver );
    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        CommonFunction.screenShot(result);
    }

    //case 1 Kiểm tra dăng kí đúng
    @Step("Register_01")
    @Test
    public void Test_01() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname, Constant.lname, Constant.email, Constant.password, Constant.password, "fname", InterfaceRegister.mess_error_fname_empty);
    }
    @Step("Register_02")
    @Test
    public void Test_02() throws Exception {
        InterfaceRegister.Register(driver, "", Constant.lname, Constant.email, Constant.password, Constant.password, "fname", InterfaceRegister.mess_error_fname_empty);
    }

    @Step("Register_03")
    @Test
    public void Test_03() throws Exception {
        InterfaceRegister.Register(driver,"Linh@123", Constant.lname, Constant.email, Constant.password, Constant.password, "fname", InterfaceRegister.mess_error_fname_val);
    }
    @Step("Register_04")
    @Test
    public void Test_04() throws Exception {
        InterfaceRegister.Register(driver,"Linh Dao thi thuy linh dao thi thuy", Constant.lname, Constant.email, Constant.password, Constant.password,"fname", InterfaceRegister.mess_error_fname_val);
    }
    @Step("Register_05")
    @Test
    public void Test_05() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname, "", Constant.email, Constant.password, Constant.password, "lname", InterfaceRegister.mess_error_lname_empty);
    }
    @Step("Register_06")
    @Test
    public void Test_06() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,"Dao123!@#", Constant.email, Constant.password, Constant.password, "lname" ,InterfaceRegister.mess_error_lname_val);
    }
    @Step("Register_07")
    @Test
    public void Test_07() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,"Dao Thi Thuy Linh Dao Thi Thuy Linh", Constant.email, Constant.password, Constant.password, "lname",InterfaceRegister.mess_error_lname_val);
    }
    @Step("Register_10")
    @Test
    public void Test_10() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname, Constant.lname, "", Constant.password, Constant.password, "email", InterfaceRegister.mess_error_email_empty);
    }
    @Step("Register_11")
    @Test
    public void Test_11() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname, Constant.lname, "Linh", Constant.password, Constant.password, "email", InterfaceRegister.mess_error_email_val);
    }
    @Step("Register_12")
    @Test
    public void Test_12() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname, Constant.lname, Constant.email, Constant.password, Constant.password, "email_exists", InterfaceRegister.mess_error_email_already_exists);
    }
    @Step("Register_13")
    @Test
    public void Test_13() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,Constant.lname, Constant.email, "", Constant.password, InterfaceRegister.mess_error_pass_empty);
    }
    @Step("Register_14")
    @Test
    public void Test_14() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,Constant.lname, Constant.email, "12", Constant.password, InterfaceRegister.mess_error_pass_val);
    }
    @Step("Register_15")
    @Test
    public void Test_15() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,Constant.lname, Constant.email, Constant.password, "", InterfaceRegister.mess_error_confirm_pass_empty);
    }
    @Step("Register_16")
    @Test
    public void Test_16() throws Exception {
        InterfaceRegister.Register(driver, Constant.fname,Constant.lname, Constant.email, Constant.password,"12", InterfaceRegister.getMess_error_confirm_pass_val);
    }

}
