package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;
import Interface.InterfaceUpdateInfor;

public class update_infor {

    private static WebDriver driver;
    @BeforeTest
    public void setUp() throws Exception {
        driver = CommonFunction.initWebDriver(Constant.URL_TEST);
        InterfaceLogin.login(driver, Constant.email, Constant.password, "");
        driver.findElement(By.xpath("//a[normalize-space()='" + Constant.email + "']")).click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        CommonFunction.shutDownDriver(driver);
    }

    @Test
    public void TEST_02() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "", "Dao", Constant.email,InterfaceUpdateInfor.mess_error_fname_empty);
    }

    @Test
    public void TEST_03() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "123", "Dao", Constant.email, InterfaceUpdateInfor.mess_error_name_val);
    }
    @Test
    public void TEST_04() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "    Linh    ", "Dao", Constant.email, "");
    }

    @Test
    public void TEST_05() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Dao Thi Thuy Linh Dao Thi Thuy Linh Dao Thi Thuy Linh", "Dao", Constant.email, InterfaceUpdateInfor.mess_error_name_val);
    }


    @Test
    public void TEST_06() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "", Constant.email, InterfaceUpdateInfor.mess_error_lname_empty);
    }
    @Test
    public void TEST_07() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "123!@#", Constant.email, InterfaceUpdateInfor.mess_error_name_val);
    }

    @Test
    public void TEST_8() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh","    Dao    ",Constant.email, "");
    }

    @Test
    public void TEST_09() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "Dao Thi Thuy Linh Dao Thi Thuy Linh Dao Thi Thuy Linh", Constant.email, InterfaceUpdateInfor.mess_error_name_val);
    }

    @Test
    public void TEST_10() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "Dao", "", InterfaceUpdateInfor.mess_error_email_empty);
    }

    @Test
    public void TEST_11() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "Dao", "a", InterfaceUpdateInfor.mess_error_email_val);
    }

    @Test
    public void TEST_13() throws Exception {
        InterfaceUpdateInfor.updateInfor(driver, "Linh", "Dao", Constant.email, "");
    }


}
