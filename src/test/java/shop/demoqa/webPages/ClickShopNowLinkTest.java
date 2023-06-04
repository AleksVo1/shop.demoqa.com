package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ClickShopNowLinkTest extends BasePageTest{

    @Test(groups = "smoke")
    @Description ("Fails to click Shop Now link.")
    public void testClickShopNowLink() {
        HomePage homePage = new HomePage(driver);
            open("");
                log.info("Home page is open.");

            homePage.waitForVisibility(homePage.shopNowLink);
                homePage.clickShopNowLink();
                    log.info("Clicked on Shop Now link.");

        boolean isCatalogPageLoaded = homePage.clickShopNowLink();
        Assert.assertFalse(isCatalogPageLoaded, "Catalog page is not loaded successfully");
            log.info("Fails to click Shop Now link.");

    }
}