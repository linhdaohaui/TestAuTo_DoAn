package Common;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunction {

    private static WebDriver driver = null;

    public static WebDriver initWebDriver(String url) {
        WebDriverManager.chromedriver().setup(); // Dùng WebDriverManager thay cho setProperty
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=vi");
        driver = new ChromeDriver(options); // Khởi tạo browser
        driver.manage().window().maximize(); // Tối đa hóa cửa sổ trình duyệt
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout ngầm định
        driver.get(url); // Mở trang web
        return driver;
    }

    public static void shutDownDriver(WebDriver driver) throws InterruptedException {
        driver.close();
        TimeUnit.SECONDS.sleep(3); // Đợi 3 giây trước khi kết thúc hẳn
    }

    public static void clickItem(WebDriver driver, String elementXpath) throws Exception {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
        TimeUnit.SECONDS.sleep(1);
    }

    public static WebElement getWebElementByXpath(WebDriver driver, String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public static void clearText(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public static void sendKeys(WebDriver driver, String elementXpath, String inputData) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        if (!inputData.isEmpty()) {
            element.sendKeys(inputData);
        }
    }

    public static void assertTextValue(WebDriver driver, String elementXpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        String actualText = element.getText();
        assertEquals(expectedText, actualText);
    }

    public static int getXpathCount(WebDriver driver, String elementXpath) {
        List<WebElement> listElements = driver.findElements(By.xpath(elementXpath));
        return listElements.size(); // Tối ưu hơn so với dùng biến đếm
    }
}
