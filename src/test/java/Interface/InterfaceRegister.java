package Interface;

public class InterfaceRegister {
    public static String male = "//input[@id='gender-male']";
    public static String female ="//input[@id='gender-female']";
    public static String xpath_txt_fname ="//input[@id='FirstName']";
    public static String xpath_txt_lname = "//input[@id='LastName']";
    public static String xpath_txt_email ="//input[@id='Email']";
    public static String xpath_pass ="//input[@id='Password']";
    public static String xpath_confirm_pass ="//input[@id='ConfirmPassword']";
    public static String button_register ="//input[@id='register-button']";

    public static String xpath_error_fname ="//span[@data-valmsg-for='FirstName']";
    public static String xpath_error_lname ="//span[@for='LastName']";
    public static String xpath_error_email ="//span[@for='Email']";
    public static String xpath_error_pass ="//span[@for='Password']";
    public static String xpath_error_confirm_pass ="//span[@for='ConfirmPassword']";
    public static String xpath_error_email_already_exists = "//li[normalize-space()='The specified email already exists']";

    public static String mess_error_fname_empty = " First name is required.";
    public static String mess_error_lname_empty ="Last name is required.";
    public static String mess_error_email_empty = "Email is required.";
    public static String mess_error_email_val =" Wrong email";
    public static String mess_error_email_already_exists = "The specified email already exists";
    public static String mess_error_pass_empty ="Password is required.";
    public static String mess_error_pass_val =" The password should have at least 6 characters.";
    public static String mess_error_confirm_pass_empty ="Password is required.";
    public static String getMess_error_confirm_pass_val ="The password and confirmation password do not match.";


}
