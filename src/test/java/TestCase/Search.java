package TestCase;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceSearch;


public class Search {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpForClass() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        CommonFunction.clickItem(driver, InterfaceSearch.XPATH_SEARCH_TXT);
    }


    @AfterClass
    public static void tearDownForClass() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }
    @Step("Search_Test01")
    @Test
    public void TEST_01() throws Exception {
        InterfaceSearch.searchProduct(driver, "", true);
    }
    @Step("Search_Test02")
    @Test
    public void TEST_02() throws Exception {
        InterfaceSearch.searchProduct(driver, "Copy", true);
    }
    @Step("Search_Test03")
    @Test
    public void TEST_03() throws Exception {
        InterfaceSearch.searchProduct(driver, "test", false);
    }
    @Step("Search_Test04")
    @Test
    public void TEST_04() throws Exception {
        InterfaceSearch.searchProduct(driver, "Copy of Computing and Internet EX".toUpperCase(), true);
    }
    @Step("Search_Test05")
    @Test
    public void TEST_05() throws Exception {
        InterfaceSearch.searchProduct(driver, "          ", true);
    }
}
