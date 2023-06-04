package shop.demoqa.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrdersPage extends BasePage{

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderRowDisplayed(String orderNumber) {
        WebElement ordersTable = driver.findElement(By.cssSelector(".woocommerce table.my_account_orders"));
            String orderXpath = "//tr[contains(@class, 'order') and .//a[contains(text(), '" + orderNumber + "')]]";
                WebElement orderRow = ordersTable.findElement(By.xpath(orderXpath));
                    waitForVisibility(orderRow);
                        return orderRow.isDisplayed();
    }
}
