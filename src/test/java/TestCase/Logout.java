package TestCase;

import Interface.InterfaceLogout;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.CommonFunction;
import Common.Constant;

public class Logout {

    private static WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        Interface.InterfaceLogin.login(driver, Constant.email, Constant.password, "");
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }

    @Test
    public void Test_01() throws Exception {
        InterfaceLogout.logout(driver);
    }

}
