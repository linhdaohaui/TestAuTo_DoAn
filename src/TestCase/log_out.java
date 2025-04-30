package TestCase;

import org.openqa.selenium.WebDriver;


import Common.CommonFunction;
import Common.Constant;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class log_out {
	
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
	public void Test_01() {
		
	}

}
