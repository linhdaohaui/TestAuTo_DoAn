package TestCase;

import Interface.InterfaceLogout;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.CommonFunction;
import Common.Constant;
@Epic("Test")
@Feature("Test")
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
    @Step("Test 01")
    @Test
    public void Test_01() throws Exception {
        InterfaceLogout.logout(driver);
    }

}
