package shop.demoqa.webPages;

import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.demoqa.webPages.BasePageTest;
import shop.demoqa.webPages.HomePage;
import shop.demoqa.webPages.SearchPage;

@Slf4j
public class SortByPriceTest extends BasePageTest {

    @Test(groups = "functional")
    @Description("Testing the functionality of sorting products by price")
    public void testSortByPrice(){

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

        searchPage.sortByPriceHighToLow();
            log.info("Products displayed sorted from high to low");


        searchPage.sortByPriceHighToLow();
            log.info("Products displayed sorted from high to low");

        Assert.assertTrue(searchPage.isSortedByPriceDescending());

        searchPage.sortByPriceLowToHigh();
            log.info("Products displayed sorted from low to high");

        Assert.assertTrue(searchPage.isSortedByPriceAscending());

    }
}
