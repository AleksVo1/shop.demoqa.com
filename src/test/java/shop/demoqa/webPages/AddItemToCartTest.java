package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class AddItemToCartTest extends BasePageTest{

    @Test(groups = "smoke")
    @Description("Verification of adding an item to the cart.")
    public void testAddItemToCart(){

        HomePage homePage = new HomePage(driver);
            open("");
                    homePage.dismissNoticeMessage();
                        log.info("Closed notice message.");
                            homePage.clickMyAccountLink();
                                log.info("Clicked on My Account link.");

        LogInPage logInPage = new LogInPage(driver);
            logInPage.login("Student", "password_password");
                log.info("User is logged in");
                    logInPage.logo.click();
                        log.info("Clicked on Demoqa logo.");

        homePage.clickPinkDropItem();
            homePage.clickPinkDropItem();
                log.info("Clicked on PINK DROP SHOULDER OVERSIZED T SHIRT item.");

        PinkDropItemPage pinkDropItemPage = new PinkDropItemPage(driver);

        Assert.assertTrue(pinkDropItemPage.isPinkDropPageTitleDisplayed(), "Page with tittle" +
                " “PINK DROP SHOULDER OVERSIZED T SHIRT” is displayed");

        pinkDropItemPage.selectPinkDropPageColor();
            log.info("Color pink selected");

        pinkDropItemPage.selectPinkDropPageSize();
            log.info("Size 3 selected");

        pinkDropItemPage.clickPinkDropPageAddToCartButton();
            log.info("Item added to cart");

        pinkDropItemPage.clickToPinkDropPageCartIcon();
            log.info("Clicked on cart icon");

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isCartTitleDisplayed(), "Cart title is displayed.");

        Assert.assertTrue(cartPage.isPinkDropTitleCartDisplayed(), "Correct product name is displayed");

    }
}
