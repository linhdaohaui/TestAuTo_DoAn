package Interface;

public class InterfaceForgotPassword {
    public static String xpath_txt_email = "//input[@id='Email']";
    public static String xpath_button_Recover = "//input[@name='send-email']";

    public static String error_email = "//input[@name='send-email']";
    public static String email_success = "//div[@class='result']";

    public static String mess_error_email_val ="Wrong email";
    public static String mess_error_email_empty ="Enter your email";
    public static String mess_success ="Email with instructions has been sent to you.";
    public static String messs_error_find ="Email not found.";


}
