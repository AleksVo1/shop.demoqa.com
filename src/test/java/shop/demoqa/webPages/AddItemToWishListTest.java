package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class AddItemToWishListTest extends BasePageTest{

    @Test(groups = "smoke")
    @Description("Adding a Product to Wishlist.")
    public void testAddItemToWishList(){

        HomePage homePage = new HomePage(driver);
            open("");
                log.info("Home page is open.");
                    homePage.dismissNoticeMessage();
                        log.info("Closed notice message.");
                            homePage.clickMyAccountLink();
                                log.info("Clicked on My Account link.");

        LogInPage logInPage = new LogInPage(driver);
            logInPage.login("Student", "password_password");
                log.info("User is logged in");
                    logInPage.clickLogo();
                        log.info("Clicked on Demoqa logo.");

            homePage.addToWishListPinkDropItem();
                log.info("Item added to Wish List.");

            homePage.clickToWishList();
                log.info("Clicked on Wish List link.");

        WishListPage wishListPage = new WishListPage(driver);

        Assert.assertTrue(wishListPage.isWishListTitleDisplayed(), "Wish list title is not displayed");

        Assert.assertTrue(wishListPage.isPinkDropTitleWishListDisplayed(),
                "Added item is not displayed in Wish List");

    }
}
