package Interface;

import Common.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class InterfaceManagerCart {
    //public static  String xpath_btt_cart_list = "//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]";
    public static String getXpathQuantityInput(String productId) {
        return "//input[@id='addtocart_" + productId + "_EnteredQuantity']";
    }
    public static String getXpathAddToCartButton(String productId) {
        return "//input[@id='add-to-cart-button-" + productId + "']";
    }
    public static String xpath_total_qty ="//span[@class='cart-qty']";
    public static String emptyCartMsg = "//div[@class='order-summary-content']";

    public static String xpath_noti_content = "//p[@class='content']";
    public static String eror_mess = "Quantity should be positive";
    public static String succ_mess = "The product has been added to your shopping cart";
    public static String cart_empty ="Your Shopping Cart is empty!";
    public static String getProductByIndex(WebDriver driver, int index) {
        List<WebElement> products = driver.findElements(By.cssSelector("div.product-item"));
        if (index < 1 || index > products.size()) {
            System.out.println("Index không hợp lệ: " + index);
            return null;
        }
        WebElement product = products.get(index - 1); // vì List bắt đầu từ 0
        String productId = product.getAttribute("data-productid");
        System.out.println("Index: " + index + " | Product ID: " + productId);
        return productId;
    }

    public static void removeItemByIndex(WebDriver driver, int index) throws Exception {
        List<WebElement> checkboxes = driver.findElements(By.name("removefromcart"));
        int totalBefore = checkboxes.size();
        if (index < 0 || index >= checkboxes.size()) {
            throw new IllegalArgumentException("Index không hợp lệ: " + index);
        }
        WebElement checkboxToRemove = checkboxes.get(index);
        if (!checkboxToRemove.isSelected()) {
            checkboxToRemove.click();
        }
        WebElement updateButton = driver.findElement(By.xpath("//input[@name='updatecart']"));
        updateButton.click();
        List<WebElement> checkboxesAfter = driver.findElements(By.name("removefromcart"));
        int totalAfter = checkboxesAfter.size();
        Assert.assertEquals(totalAfter, totalBefore-1);
    }

    public static void removeAllItemsFromCart(WebDriver driver) throws Exception {
        List<WebElement> checkboxes = driver.findElements(By.name("removefromcart"));
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click(); // tick ô xóa
            }
        }

        WebElement updateButton = driver.findElement(By.name("updatecart"));
        updateButton.click();

        Thread.sleep(1000);
        CommonFunction.assertTextValue(driver,emptyCartMsg, cart_empty);
    }


    public static void validatePositiveNumber(WebDriver driver,String qty, String cart,String input, String errorMess) throws Exception {
        CommonFunction.sendKeys(driver, qty, input);
        CommonFunction.clickItem(driver, cart);
        String trimmed = input.trim();
        if (!trimmed.matches("\\d+(\\.\\d+)?")) {
            CommonFunction.assertTextValue(driver,xpath_noti_content,errorMess);
            return;
        }
        double number = Double.parseDouble(trimmed);
        if (number <= 0) {
            CommonFunction.assertTextValue(driver,xpath_noti_content,errorMess);
            return;
        }
    }
}
