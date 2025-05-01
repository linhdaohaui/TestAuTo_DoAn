package Interface;

import Common.CommonFunction;
import org.openqa.selenium.WebDriver;

public class InterfaceForgotPassword {
    // Xpath phần tử
    public static String xpath_txt_email = "//input[@id='Email']";
    public static String xpath_button_Recover = "//input[@name='send-email']";

    // Xpath của phần tử chứa thông báo lỗi và thông báo thành công
    public static String xpath_error_message = "//span[@class='field-validation-error']";
    public static String xpath_success_message = "//div[@class='result']";

    // Các thông báo mong đợi
    public static String mess_error_email_val = "Wrong email";
    public static String mess_error_email_empty = "Enter your email";
    public static String mess_success = "Email with instructions has been sent to you.";
    public static String messs_error_find = "Email not found.";

    public static void forgotFass(WebDriver driver, String mail, String expectedMessage) throws Exception {
        // Nhập email và nhấn "Recover"
        CommonFunction.sendKeys(driver, xpath_txt_email, mail);
        CommonFunction.clickItem(driver, xpath_button_Recover);

        // Trim để loại bỏ khoảng trắng thừa
        String trimmedMail = mail.trim();

        // Kiểm tra email rỗng
        if (trimmedMail.isEmpty()) {
            CommonFunction.assertTextValue(driver, xpath_error_message, expectedMessage);
            return;
        }

        // Kiểm tra định dạng không hợp lệ
        if (!trimmedMail.contains("@") || !trimmedMail.contains(".")) {
            CommonFunction.assertTextValue(driver, xpath_error_message, expectedMessage);
            return;
        }

        // Trường hợp email không tồn tại (thông báo lỗi phía server)
        if (expectedMessage.equals(messs_error_find)) {
            CommonFunction.assertTextValue(driver, mess_success, expectedMessage);
            return;
        }

        // Trường hợp thành công
        if (expectedMessage.equals(mess_success)) {
            CommonFunction.assertTextValue(driver, xpath_success_message, expectedMessage);
            return;
        }

        // Nếu không có bất kỳ thông báo nào phù hợp
        throw new AssertionError("Không xác định được thông báo phản hồi phù hợp cho dữ liệu đầu vào: '" + mail + "'");
    }
}
