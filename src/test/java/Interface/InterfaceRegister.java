package Interface;

import Common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class InterfaceRegister {
    public static String male = "//input[@id='gender-male']";
    public static String female ="//input[@id='gender-female']";
    public static String xpath_txt_fname ="//input[@id='FirstName']";
    public static String xpath_txt_lname = "//input[@id='LastName']";
    public static String xpath_txt_email ="//input[@id='Email']";
    public static String xpath_txt_pass ="//input[@id='Password']";
    public static String xpath_txt_confirm_pass ="//input[@id='ConfirmPassword']";
    public static String button_register ="//input[@id='register-button']";


    public static String xpath_error_fname ="//span[@for='FirstName']";

    public  static String css_fname ="span[for='FirstName']";
    public static String xpath_error_lname ="//span[@for='LastName']";
    public static String xpath_error_email ="//span[@class='field-validation-error']";
    public static String xpath_error_pass ="//span[@for='Password']";
    public static String xpath_error_confirm_pass ="//span[@for='ConfirmPassword']";
    public static String xpath_error_email_already_exists = "//li[normalize-space()='The specified email already exists']";

    public static String mess_error_fname_empty = "First name is required.";
    public static String mess_error_fname_val = "First name is contain special characters";
    public static String mess_error_lname_empty ="Last name is required.";
    public static String mess_error_lname_val = "Last name is contain spacial characters";
    public static String mess_error_email_empty = "Email is required.";
    public static String mess_error_email_val ="Wrong email";
    public static String mess_error_email_already_exists = "The specified email already exists";
    public static String mess_error_pass_empty ="Password is required.";
    public static String mess_error_pass_val ="The password should have at least 6 characters.";
    public static String mess_error_confirm_pass_empty ="Password is required.";
    public static String getMess_error_confirm_pass_val ="The password and confirmation password do not match.";
    public static void Register1(WebDriver driver, String fname, String lname, String email, String pass, String confirm_pass) throws Exception {
        CommonFunction.clickItem(driver, male);
        CommonFunction.sendKeys(driver, xpath_txt_fname, fname);
        CommonFunction.sendKeys(driver, xpath_txt_lname, lname);
        CommonFunction.sendKeys(driver, xpath_txt_email, email);
        CommonFunction.sendKeys(driver, xpath_txt_pass, pass);
        CommonFunction.sendKeys(driver, xpath_txt_confirm_pass, confirm_pass);
        CommonFunction.clickItem(driver, button_register);
    }
    public static void Register(WebDriver driver, String fname, String lname, String email, String pass, String confirm_pass, String error_mess) throws Exception {
        CommonFunction.clickItem(driver,male);
        CommonFunction.sendKeys(driver, xpath_txt_fname, fname);
        CommonFunction.sendKeys(driver,xpath_txt_lname, lname);
        CommonFunction.sendKeys(driver, xpath_txt_email, email);
        CommonFunction.sendKeys(driver,xpath_txt_pass, pass);
        CommonFunction.sendKeys(driver,xpath_txt_confirm_pass,confirm_pass);
        CommonFunction.clickItem(driver, button_register);

        boolean hasError = false;

        if(lname.trim().isEmpty()){
            CommonFunction.assertTextValue(driver, xpath_error_lname, error_mess);
            hasError = true;
        }
        if(email.isEmpty()){
            CommonFunction.assertTextValue(driver, xpath_error_email, error_mess);
        }
        if(pass.trim().isEmpty()){
            CommonFunction.assertTextValue(driver, xpath_error_pass, error_mess);
        }
        if(confirm_pass.trim().isEmpty()){
            CommonFunction.assertTextValue(driver,xpath_error_confirm_pass, error_mess);
        }
        if(!email.trim().contains("@") || !email.trim().contains(".")){
            CommonFunction.assertTextValue(driver, xpath_error_email, error_mess);
        }
        if(pass.length() <6){
            CommonFunction.assertTextValue(driver,xpath_error_pass,error_mess);
        }
        if(confirm_pass.equalsIgnoreCase(pass)){
            CommonFunction.assertTextValue(driver, xpath_error_confirm_pass, error_mess);
        }
        if(fname.length() >= 25) {
            String actualError = driver.findElement(By.xpath(xpath_error_fname)).getText().trim();;

            // Nếu không có lỗi hoặc lỗi không đúng => test FAIL
            if (actualError.isEmpty() || !actualError.equals(error_mess)) {
                throw new Exception("Expected error message for LastName not displayed. Got: '" + actualError + "'");
            }

            hasError = true;
        }
        if(lname.length() >= 25) {
            String actualError = driver.findElement(By.xpath(xpath_error_lname)).getText().trim();;

            // Nếu không có lỗi hoặc lỗi không đúng => test FAIL
            if (actualError.isEmpty() || !actualError.equals(error_mess)) {
                throw new Exception("Expected error message for LastName not displayed. Got: '" + actualError + "'");
            }

            hasError = true;
        }
        if (fname.matches(".*[^a-zA-Z\\s].*")) {
            String actualError = driver.findElement(By.xpath(xpath_error_fname)).getText().trim();;

            if (actualError.isEmpty() || !actualError.equals(error_mess)) {
                throw new Exception("Expected error for single special character in LastName not displayed. Got: '" + actualError + "'");
            }

            hasError = true;
        }
        if (lname.matches(".*[^a-zA-Z\\s].*")) {
            String actualError = driver.findElement(By.xpath(xpath_error_lname)).getText().trim();;

            if (actualError.isEmpty() || !actualError.equals(error_mess)) {
                throw new Exception("Expected error for single special character in LastName not displayed. Got: '" + actualError + "'");
            }

            hasError = true;
        }

    }
    public static void Register(WebDriver driver, String fname, String lname, String email, String pass, String confirm_pass, String expectedField, String expectedMessage) throws Exception {
        CommonFunction.clickItem(driver,male);
        CommonFunction.sendKeys(driver, xpath_txt_fname, fname);
        CommonFunction.sendKeys(driver, xpath_txt_lname, lname);
        CommonFunction.sendKeys(driver, xpath_txt_email, email);
        CommonFunction.sendKeys(driver, xpath_txt_pass, pass);
        CommonFunction.sendKeys(driver, xpath_txt_confirm_pass, confirm_pass);
        CommonFunction.clickItem(driver, button_register);

        String xpath = null;

        switch (expectedField) {
            case "fname":
                xpath = xpath_error_fname;
                break;
            case "lname":
                xpath = xpath_error_lname;
                break;
            case "email":
                xpath = xpath_error_email;
                break;
            case "pass":
                xpath = xpath_error_pass;
                break;
            case "confirm_pass":
                xpath = xpath_error_confirm_pass;
                break;
            case "email_exists":
                xpath = xpath_error_email_already_exists;
                break;
            default:
                throw new Exception("Unknown field for validation: " + expectedField);
        }

        String actualError = driver.findElement(By.xpath(xpath)).getText().trim();
        if (!actualError.equals(expectedMessage)) {
            throw new Exception("Expected: '" + expectedMessage + "' but got: '" + actualError + "'");
        }
    }




}
