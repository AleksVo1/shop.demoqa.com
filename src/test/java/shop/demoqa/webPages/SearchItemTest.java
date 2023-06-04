package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class SearchItemTest extends BasePageTest{

    @Test(groups = "functional")
    @Description("The names of all products contain the substring dress")
    public void testSearchItem(){
        HomePage homePage = new HomePage(driver);
            homePage.open("");
                log.info("Home page is open.");

            homePage.performSearch("Dress");
                log.info("Search is successful");

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(searchPage.isSearchResultDisplayed(), "Search results are not displayed");
            log.info("Search results are displayed");

        Assert.assertTrue(searchPage.doAllProductNamesContain("dress"),
                "All product contain 'dress'");
            log.info("All product contain the 'dress'.");
    }
}