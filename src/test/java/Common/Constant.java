package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Constant {

    public static final String URL_TEST = "https://demowebshop.tricentis.com/login";
    public static final String email = "daothuylinh6823@gmail.com";
    public static final String password = "12345678";
    public static final String fname= "Linh";
    public static final String lname ="Dao";
    public static final  String pass ="123456";

    // Hàm khởi tạo WebDriver
    public static WebDriver initWebDriver() {
        WebDriverManager.chromedriver().setup(); // Tự động cấu hình driver
        return new ChromeDriver();
    }
}

