package shop.demoqa.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PinkDropItemModal extends BasePage{

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/h1")
    protected WebElement pinkDropTitle;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/p/span/bdi")
    protected WebElement pinkDropPrice;

    @FindBy(className = "sku_wrapper")
    protected WebElement pinkDropSKU;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[3]/span[2]/a")
    protected WebElement pinkDropCategory;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[3]/span[3]")
    protected WebElement pinkDropTAGS;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/a")
    protected WebElement pinkDropSelectOptions;

    public PinkDropItemModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPinkDropTitleDisplayed(){
        waitForVisibility(pinkDropTitle);
            return pinkDropTitle.isDisplayed();
    }

    public boolean isPinkDropPriceDisplayed(){
        return pinkDropPrice.isDisplayed();
    }

    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    public boolean isItemDataDisplayed(){
        return isElementDisplayed(pinkDropSKU) &&
        isElementDisplayed(pinkDropCategory) &&
        isElementDisplayed(pinkDropTAGS);
    }

    public boolean isSelectOptionsEnabled(){
        return pinkDropSelectOptions.isEnabled();
    }
}
