package Interface;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.CommonFunction;

public class InterfaceUpdateInfor {
	public static String xpath_radio_gender_male = "//input[@id='gender-male']";
	public static String xpath_radio_female = "//input[@id='gender-female']";
	public static String xpath_txt_fname = "//input[@id='FirstName']"; 
	public static String xpath_txt_lname ="//input[@id='LastName']";
	public static String xpath_txt_email = "//input[@id='Email']";
	
	public static String xpath_button_save = "//input[@name='save-info-button']";

	
	public static String error_fname ="//span[@for='FirstName']";
	public static String eror_lname ="//span[@for='LastName']";
	public static String error_email ="//span[@for='Email']";
	
	
	public static String mess_error_fname_empty ="";
	public static String mess_error_lname_empty ="";
	public static String mess_error_email_empty = "";
	public static String mess_error_email_val ="";
	
	public static void updateInfor(WebDriver driver, String fname, String lname, String email, String errorMessage) throws Exception {
	    CommonFunction.sendKeys(driver, xpath_txt_fname, fname);
	    CommonFunction.sendKeys(driver, xpath_txt_lname, lname);
	    CommonFunction.sendKeys(driver, xpath_txt_email, email);
	    CommonFunction.clickItem(driver, xpath_button_save);

	    boolean hasError = false;

	    if (fname.trim().isEmpty()) {
	        CommonFunction.assertTextValue(driver, error_fname, errorMessage);
	        hasError = true;
	    }
	    if (lname.trim().isEmpty()) {
	        CommonFunction.assertTextValue(driver, eror_lname, errorMessage);
	        hasError = true;
	    }
	    if (email.trim().isEmpty()) {
	        CommonFunction.assertTextValue(driver, error_email, errorMessage);
	        hasError = true;
	    }

	    if (!hasError && errorMessage.trim().isEmpty()) {
	        String fname_actual = driver.findElement(By.xpath(xpath_txt_fname)).getAttribute("value");
	        String lname_actual = driver.findElement(By.xpath(xpath_txt_lname)).getAttribute("value");
	        String email_actual = driver.findElement(By.xpath(xpath_txt_email)).getAttribute("value");
	        driver.findElement(By.xpath(xpath_radio_gender_male)).click();
	        assertTrue(driver.findElement(By.xpath(xpath_radio_gender_male)).isSelected());
	        assertEquals(fname_actual.trim(), fname);
	        assertEquals(lname_actual.trim(), lname);
	        assertEquals(email_actual.trim(), email);
	    }
	}

	
	
	
			
}
