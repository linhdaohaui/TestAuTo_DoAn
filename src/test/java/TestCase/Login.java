package TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;

import java.io.File;
import java.io.IOException;

public class Login {
    private static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }

    @AfterMethod
    public void screenShort(ITestResult result) throws IOException {
        CommonFunction.screenShot(result);
    }
    @Test (priority = 1)
    public void TEST_02() throws Exception {
        InterfaceLogin.login(driver, "", Constant.password, InterfaceLogin.mess_empty_error);
    }

    @Test ()
    public void TEST_03() throws Exception {
        InterfaceLogin.login(driver, "linhdtt@icebear.com.vn", Constant.password, InterfaceLogin.mess_login_fail);
    }

    @Test ()
    public void TEST_04() throws Exception {
        InterfaceLogin.login(driver, "linhdao", Constant.password, InterfaceLogin.mess_incorrect_email);
    }

    @Test ()
    public void TEST_05() throws Exception {
        InterfaceLogin.login(driver, "/,@gmail.com", Constant.password, InterfaceLogin.mess_incorrect_email);
    }

    @Test ()
    public void TEST_06() throws Exception {
        InterfaceLogin.login(driver, "     " + Constant.email + "     ", Constant.password, "");
    }
    @Test ()
    public void TEST_07() throws Exception {
        InterfaceLogin.login(driver,Constant.email, "", InterfaceLogin.mess_empty_error);
    }
    @Test ()
    public void TEST_08() throws Exception {
        InterfaceLogin.login(driver,Constant.email, "123", InterfaceLogin.mess_incorrect_password);
    }
    @Test ()
    public void TEST_09() throws Exception {
        InterfaceLogin.login(driver,Constant.email, "87654321", InterfaceLogin.mess_login_fail);
    }
    @Test (priority = 2)
    public void TEST_01() throws Exception {
        InterfaceLogin.login(driver, Constant.email, Constant.password, "");
    }
}
