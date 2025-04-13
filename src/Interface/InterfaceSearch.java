package Interface;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Common.CommonFunction;

public class InterfaceSearch {
	public static String XPATH_SEARCH_TXT 				= "//input[@id='small-searchterms']";
	public static String XPATH_SEARCH_BTN 				= "//input[@value='Search']";
	
	public static String XPATH_SEARCH_PRODUCT_LINK		= "//div[@class='product-item']//a";

	public static void searchProduct(WebDriver driver, String keyword, boolean isSuccess) throws Exception {
	    // Nhập từ khóa vào ô tìm kiếm
	    CommonFunction.sendKeys(driver, XPATH_SEARCH_TXT, keyword);
	    
	    // Click vào nút Search
	    CommonFunction.clickItem(driver, XPATH_SEARCH_BTN);
	    
	    // Kiểm tra alert nếu từ khóa trống hoặc là placeholder
	    if (keyword.trim().isEmpty() || keyword.equals("Search store")) {
	        try {
	            // Đảm bảo alert xuất hiện khi từ khóa trống
	            Alert alert = driver.switchTo().alert();
	            String titleAlert = alert.getText();
	            System.out.println("Alert text: " + titleAlert);
	            
	            // Kiểm tra nội dung alert
	            assertEquals(titleAlert, "Please enter some search keyword");
	            alert.accept(); // Đóng alert
	        } catch (NoAlertPresentException e) {
	            // Nếu không có alert, kiểm tra lại
	            Assert.fail("Alert không xuất hiện khi tìm kiếm trống.");
	        }
	    } else {
	        // Kiểm tra kết quả tìm kiếm nếu nhập từ khóa
	        int resultCount = CommonFunction.getXpathCount(driver, XPATH_SEARCH_PRODUCT_LINK);
	        if (isSuccess) {
	            assertNotEquals(resultCount, 0); // Kiểm tra không phải kết quả rỗng
	        } else {
	            assertEquals(resultCount, 0); // Kiểm tra không có kết quả nào
	        }
	    }
	}


}
