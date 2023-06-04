package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class E2E extends BasePageTest{

    @Test(groups = "E2E")
    @Description("Purchase of products.")
    public void testE2E(){

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

        homePage.clickToQuickViewPinkDropItem();

//        Assert.assertTrue();

        homePage.clickToSelectOptions();

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

        cartPage.clickToCheckoutButton();
            log.info("Clicked on Checkout button");

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        Assert.assertTrue(checkoutPage.isCheckoutTitleDisplayed(), "Checkout title is displayed");

        Assert.assertTrue(checkoutPage.isOrderDetailsItemDisplayed(), "Order details is not displayed");

        checkoutPage.fillOutBillingDetails("Ukraine", "adress 1", "City 1",
                "Kharkivshchyna", "66555", "09512345678", "ms.awhile@gmail.com");
        log.info("Fill out billing details");

        checkoutPage.selectCheckBox();
            log.info("Check box selected");

        checkoutPage.clickToPlaceOrderButton();
            log.info("Clicked checkout button");

        Assert.assertTrue(checkoutPage.isThankYouMassageDisplayed(), "Thank you is not displayed.");
            log.info("Order placed successfully.");

        Assert.assertTrue(checkoutPage.isOrderDetailsDisplayed(), "Order details isn't displayed");
        log.info("Order details is displayed");

        Assert.assertTrue(checkoutPage.isBillingAddressDisplayed(), "Billing address isn't displayed");
        log.info("Billing address is displayed");

        String orderNumber = checkoutPage.getOrderNumber();
            log.info("Get order number on checkout page.");

        checkoutPage.clickToMyAccountLinkCheckoutPage();
            log.info("Clicked on My Account.");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickToOrdersLink();
                log.info("Clicked on Orders link.");

        OrdersPage ordersPage = new OrdersPage(driver);

        Assert.assertTrue(ordersPage.isOrderRowDisplayed(orderNumber));
            log.info("Order number is correct.");

    }
}
