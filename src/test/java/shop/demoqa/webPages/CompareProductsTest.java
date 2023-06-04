package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CompareProductsTest extends BasePageTest{

    @Test(groups = "functional")
    @Description("Testing product comparison.")
    public void testCompareProducts() {

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

        homePage.clickToCompareIconPinkDropItem();
            log.info("Click on compare icon of pink drop item");

        CompareModal compareModal = new CompareModal(driver);

        Assert.assertTrue(compareModal.isCompareProductsTitleDisplayed(), "Title isn't displayed");
            log.info("Compare title is displayed");

        compareModal.clickToCloseCompareModal();
            log.info("Clicked on the cross icon to close Compare Modal");

        homePage.clickToCompareIconPlayboyItem();
            log.info("Click on compare icon of playboy item");

        Assert.assertTrue(compareModal.isCompareProductsTitleDisplayed2(), "Title isn't displayed");
        log.info("Compare title is displayed");

        Assert.assertTrue(compareModal.isFirstItemTitleDisplayed(), "Item title is not displayed");
            log.info("Title of the first item is displayed");

        Assert.assertTrue(compareModal.isSecondItemTitleDisplayed(), "Item title is not displayed");
        log.info("Title of the second item is displayed");

        compareModal.clickToRemoveFirstItem();
            log.info("First item removed from the Compare modal");

        compareModal.clickToRemoveSecondItem();
            log.info("Second item removed from the Compare modal");

        String expected = "No products added in the compare table.";
        Assert.assertEquals(compareModal.noProductsDisplayedMessage(), expected);
            log.info("No products is displayed.");

    }
}
