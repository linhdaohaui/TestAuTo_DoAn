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
	public void TEST_01() throws Exception {
		 InterfaceUpdateInfor.updateInfor(driver, "    Linh", "Dao", Constant.email, "");
	}

}
