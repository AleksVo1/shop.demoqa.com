package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class HomePageLoadTest extends BasePageTest{

    @Test(groups = "smoke")
    @Description("Verify main page load functionality")
    public void testIsHomePageLoaded() {
        String expectedTitle = "ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site";

        HomePage homePage = new HomePage(driver);
            homePage.open("");
                log.info("Home page is open.");

        Assert.assertTrue(homePage.isHomePageLoaded(expectedTitle),"Home page is not loaded successfully");
            log.info("Home page is loaded successfully");
    }
}