package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.CommonFunction;
import Common.Constant;
import Interface.InterfaceLogin;

public class log_in {
	private static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
	}
			
	@AfterTest
	public void tearDown() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}
	@Test (priority = 0)
	public void TEST_02() throws Exception {
		 InterfaceLogin.login(driver, "", Constant.password, InterfaceLogin.mess_empty_error);
	}
	
	@Test (priority = 1)
	public void TEST_03() throws Exception {
		 InterfaceLogin.login(driver, "linhdtt@icebear.com.vn", Constant.password, InterfaceLogin.mess_login_fail);
	}
	
	@Test (priority = 2)
	public void TEST_04() throws Exception {
		 InterfaceLogin.login(driver, "linhdao", Constant.password, InterfaceLogin.mess_incorrect_email);
	}
	
	@Test (priority = 3)
	public void TEST_05() throws Exception {
		 InterfaceLogin.login(driver, ".,@gmail.com", Constant.password, InterfaceLogin.mess_incorrect_password);
	}
	
	@Test (priority = 4)
	public void TEST_06() throws Exception {
		 InterfaceLogin.login(driver, "     daothuylinh6823@gmail.com", Constant.password, InterfaceLogin.mess_login_fail);
	}
	@Test (priority = 5)
	public void TEST_07() throws Exception {
		 InterfaceLogin.login(driver,Constant.email, "", InterfaceLogin.mess_empty_error);
	}
	@Test (priority = 6)
	public void TEST_08() throws Exception {
		 InterfaceLogin.login(driver,Constant.email, "123", InterfaceLogin.mess_incorrect_password);
	}
	@Test (priority = 7)
	public void TEST_09() throws Exception {
		 InterfaceLogin.login(driver,Constant.email, "87654321", InterfaceLogin.mess_login_fail);
	}
	@Test (priority = 8)
	public void TEST_01() throws Exception {
		 InterfaceLogin.login(driver, Constant.email, Constant.password, "");
	}
	
	
}
