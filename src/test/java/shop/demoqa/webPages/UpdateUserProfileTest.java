package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class UpdateUserProfileTest extends BasePageTest {

    @Test(groups = "functional")
    @Description("Verify profile update functionality")
    public void testUpdateProfileName() {

        String username = "Student";
        String password = "password_password";
        String displayName = "User";
        String successMessageText = "Account details changed successfully.";

        HomePage homePage = new HomePage(driver);
            homePage.open("");
                log.info("Opened homepage");

            homePage.dismissNoticeMessage();
                log.info("Clicked on Dismiss link to close notice message");

            homePage.clickMyAccountLink();
                log.info("Clicked on My Account link");

        LogInPage logInPage = new LogInPage(driver);
            logInPage.login(username, password);
                log.info("Logged in with username: {}, password: {}", username, password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);

            Assert.assertTrue(myAccountPage.isMyAccountTitleDisplayed(), "Title is not displayed");
                log.info("Page is open, 'My Account' is displayed");

            myAccountPage.clickToAccountDetails();
                log.info("Clicked on Account Details link.");

        EditAccountPage editAccountPage = new EditAccountPage(driver);
            editAccountPage.updateDisplayName(displayName);

            Assert.assertTrue(editAccountPage.isAlertDisplayed(), "Success message is not displayed");

            Assert.assertEquals(editAccountPage.getSuccessMessageText(), successMessageText, "No message");
                log.info("Profile updated successfully.");
    }
}