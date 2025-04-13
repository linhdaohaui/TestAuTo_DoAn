package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;

public class InterfaceLogout {
	public static String xpath_logout = "//a[normalize-space()='Log out']";
	public static String xpath_login = "//a[normalize-space()='Log in']";
	
	public static void logout(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, xpath_logout);
		driver.findElement(By.xpath(xpath_login)).isDisplayed();
	}
}
