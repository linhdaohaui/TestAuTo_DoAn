package Common;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CommonFunction {
	
	private static WebDriver driver = null;
	
	public static WebDriver initWebDriver(String url) {
		System.setProperty(Constant.DRIVER_KEY, Constant.DRIVER_KEY_LOCATION);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=vi");
		driver = new ChromeDriver(options);// khởi tạo browser cho biến driver
		driver.manage().window().maximize(); // Để tối đa hóa cửa sổ hiện tại của trình duyệt
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// đặt thời gian ngầm định
		driver.get(url);// mở url
		return driver;
	}

	public static void shutDownDriver(WebDriver driver) throws InterruptedException {
		driver.close();
		TimeUnit.SECONDS.sleep(3);
	}
	public static void clickItem(WebDriver driver, String elementXpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(elementXpath));//xác định duy nhất một phần tử xpath trong trang web.
		try {
			element.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;// tạo một tham chiếu cho giao diện và gán nó cho cá thể WebDriver
		     executor.executeScript("arguments[0].click();", element);//click vào phần tử element
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
		int count = 0;
		for (WebElement element : listElements) {
			count++;
		}
		return count;
	}

}
