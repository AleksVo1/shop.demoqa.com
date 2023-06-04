package shop.demoqa.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(css = ".noo-product-item")
    protected List<WebElement> searchResult;

    @FindBy(css = ".noo-product-item")
    protected List<WebElement> productNames;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select")
    protected WebElement sortByHighToLow;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select")
    protected WebElement sortByLowToHigh;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchResultDisplayed(){
        wait.withTimeout(Duration.ofSeconds(10));
            return searchResult != null && !searchResult.isEmpty();
    }

    public boolean doAllProductNamesContain(String searchTerm) {
        return productNames.stream()
                .allMatch(productName -> productName.getText()
                .toLowerCase()
                .contains(searchTerm.toLowerCase()));
    }

    public void sortByPriceHighToLow(){
        Select select = new Select(sortByHighToLow);
            select.selectByValue("price-desc");
                waitForVisibility(sortByHighToLow);
    }

    public void sortByPriceLowToHigh(){
        Select select = new Select(sortByLowToHigh);
            select.selectByValue("price");
                waitForVisibility(sortByLowToHigh);
    }

    public boolean isSortedByPriceAscending() {
        List<Double> prices = new ArrayList<>();
            List<WebElement> priceElements = driver.findElements(By
                .xpath("//span[@class='price']/ins/span[@class='woocommerce-Price-amount amount']"));

        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("₹", "").replace(",", "");
                double price = Double.parseDouble(priceText);
                    prices.add(price);
        }
        List<Double> sortedPrices = new ArrayList<>(prices);

        Collections.sort(sortedPrices);
            return prices.equals(sortedPrices);
    }

    public boolean isSortedByPriceDescending() {
        List<Double> prices = new ArrayList<>();
            List<WebElement> priceElements = driver.findElements(By
                .xpath("//span[@class='price']/ins/span[@class='woocommerce-Price-amount amount']"));

        for (WebElement element : priceElements) {
            String priceText = element.getText().replace("₹", "").replace(",", "");
                double price = Double.parseDouble(priceText);
                prices.add(price);
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
            Collections.sort(sortedPrices, Collections.reverseOrder());

        return prices.equals(sortedPrices);
    }
}

