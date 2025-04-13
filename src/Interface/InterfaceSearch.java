package Interface;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;

import Common.CommonFunction;

public class InterfaceSearch {
	public static String XPATH_SEARCH_TXT 				= "//input[@id='small-searchterms']";
	public static String XPATH_SEARCH_BTN 				= "//input[@value='Search']";
	
	public static String XPATH_SEARCH_PRODUCT_LINK		= "//div[@class='product-item']//a";

	public static void searchProduct(WebDriver driver, String keyword, boolean isSuccess) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_SEARCH_TXT, keyword);
		CommonFunction.clickItem(driver, XPATH_SEARCH_BTN);
		int resultSearch = CommonFunction.getXpathCount(driver, XPATH_SEARCH_PRODUCT_LINK);
		
		if (isSuccess) {
			assertNotEquals(0, resultSearch);
		}
		else {
			assertEquals(0, resultSearch);
		}
	}

}
