package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;

public class InterfaceLogin {
	public static String xpath_email_txt = "//input[@id='Email']";
	public static String xpath_password_txt = "//input[@id='Password']"; 
	public static String xpath_login_btn = "//input[@value='Log in']";
	
	public static String error_email = "//span[@class='field-validation-error']";
	public static String error_password = "//span[@id='password-error']";
	public static String login_fail = "//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]";
	
	public static String mess_empty_error = "This field is required.";
	public static String mess_incorrect_email = "Please enter a valid email address.";
	public static String mess_incorrect_password = "Password must be at least 6 characters";
	public static String mess_login_fail = "Login was unsuccessful. Please correct the errors and try again.";
	
	
	public static void login(WebDriver driver, String email, String password, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, xpath_email_txt, email);
		CommonFunction.sendKeys(driver, xpath_password_txt, password);
		CommonFunction.clickItem(driver, xpath_login_btn);

		
		if (email == "" || password == "") {
			CommonFunction.assertTextValue(driver, error_email, errorMessage);
		}
		else if (errorMessage == "") {
			driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
		}
		else {
			CommonFunction.assertTextValue(driver, login_fail, errorMessage);
		}
	}
}
