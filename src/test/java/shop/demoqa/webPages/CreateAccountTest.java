package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class CreateAccountTest extends BasePageTest{

    @Test(groups = "E2E")
    @Description("New user registration and login")
    public void testCreateAccount(){
        HomePage homePage = new HomePage(driver);
            open("");

        homePage.dismissNoticeMessage();
            log.info("Closed notice message.");

        homePage.clickMyAccountLink();
            log.info("Clicked on My Account link.");

        LogInPage logInPage = new LogInPage(driver);
            logInPage.createAccount("Username_user_20", "adress_email_20@gmail.com", "Pass$1$2$3");
                log.info("User crested a new account.");
                    logInPage.clickToLogOutButton();
                        log.info("User logged out.");

            logInPage.login("Username_user_16", "Pass$1$2$3");
                log.info("User logged in.");

        WebElement helloMessage = driver.findElement(By.cssSelector(".woocommerce-MyAccount-content"));

        String helloText = helloMessage.getText() + logInPage.usernameField;

        Assert.assertTrue(helloText.contains("Hello"), "Hello message is not displayed.");
            log.info("Hello message is displayed");

    }

}
