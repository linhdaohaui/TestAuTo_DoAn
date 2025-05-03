package Common;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;

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

    public static void screenShot(ITestResult result) throws IOException {
        // Tạo tham chiếu của TakesScreenshot với driver hiện tại
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Gọi hàm capture screenshot - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder
        File theDir = new File("./Screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        // Lấy tên class và tên method (test case)
        String className = result.getTestClass().getRealClass().getSimpleName(); // tên class
        String methodName = result.getName(); // tên method

        // Tạo đường dẫn file với tên class và method
        String fileName = className + "_" + methodName + ".png";

        // Copy file screenshot
        FileHandler.copy(source, new File("./Screenshots/" + fileName));
        System.out.println("Screenshot taken: " + fileName);
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
    public static void checkAlertAndAccept(WebDriver driver, String expectedText) {
        try {
            // Đợi vài giây để alert xuất hiện nếu có
            Thread.sleep(1000);

            // Chuyển sang alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            // In và kiểm tra nội dung alert
            System.out.println("Alert xuất hiện với nội dung: " + alertText);
            if (!alertText.equals(expectedText)) {
                throw new AssertionError("Nội dung alert KHÔNG đúng. Mong đợi: [" + expectedText + "], thực tế: [" + alertText + "]");
            }

            // Đóng alert
            alert.accept(); // hoặc alert.dismiss() nếu cần
            System.out.println("Alert đã được accept.");

        } catch (NoAlertPresentException e) {
            System.out.println("Không có alert xuất hiện.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread bị gián đoạn.");
        }
    }
}
