package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PinkDropItemModalViewTest extends BasePageTest{

    @Test(groups = "functional")
    @Description("View PINK DROP item information")
    public void testViewProductInfo() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
            homePage.open("");
                log.info("Home page is open");

            homePage.clickToQuickViewPinkDropItem();
                log.info("Clicked on zoom icon of PINK DROP SHOULDER.");

        PinkDropItemModal pinkDropItemModal = new PinkDropItemModal(driver);
            log.info("Modal is open.");

        Assert.assertTrue(pinkDropItemModal.isPinkDropTitleDisplayed(), "PINK DROP item title is not displayed");
            log.info("Modal window is displayed");

        Assert.assertTrue(pinkDropItemModal.isPinkDropPriceDisplayed(), "₹15.00");
            log.info("Price is displayed");

        Assert.assertTrue(pinkDropItemModal.isItemDataDisplayed(), "SKU, CATEGORY,TAGS are not displayed");
            log.info("Data is displayed");

        Assert.assertTrue(pinkDropItemModal.isSelectOptionsEnabled(), "SELECT OPTIONS fails to click");
            log.info("Select options is enabled and clickable");
    }
}