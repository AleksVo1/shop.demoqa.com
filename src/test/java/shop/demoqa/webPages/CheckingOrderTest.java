package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CheckingOrderTest extends BasePageTest{

    @Test(groups = "smoke")
    @Description("Checking the order.")
    public void testCheckingOrder() {

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
                " “PINK DROP SHOULDER OVERSIZED T SHIRT” is not displayed");

        pinkDropItemPage.selectPinkDropPageColor();
            log.info("Color pink selected");

        pinkDropItemPage.selectPinkDropPageSize();
            log.info("Size 3 selected");

        pinkDropItemPage.clickPinkDropPageAddToCartButton();
            log.info("Item added to cart");

        pinkDropItemPage.clickToPinkDropPageCartIcon();
            log.info("Clicked on cart icon");

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isCartTitleDisplayed(), "Cart title is not displayed.");

        cartPage.clickToCheckoutButton();
            log.info("Clicked on Checkout button");

        CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.fillOutBillingDetails("Ukraine", "adress 1", "City 1",
                    "Kharkivshchyna", "66555", "09512345678", "ms.awhile@gmail.com");
                log.info("Fill out billing details");

            checkoutPage.selectCheckBox();
                log.info("Check box selected");

            checkoutPage.clickToPlaceOrderButton();
                log.info("Clicked checkout button");

        Assert.assertTrue(checkoutPage.isThankYouMassageDisplayed(), "Thank you.is not displayed.");
            log.info("Order placed successfully.");

    }
}
