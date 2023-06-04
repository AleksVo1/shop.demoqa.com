package shop.demoqa.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "/html/body/p")
    protected WebElement noticeMessage;

    @FindBy(xpath = "/html/body/p/a")
    protected WebElement dismissLink;

    @FindBy(css = "#noo-site > header > div.navbar-wrapper > div > a > i")
    protected WebElement searchIcon;

    @FindBy(css = "#nav-menu-item-cart > a > span")
    protected WebElement cart;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
    protected WebElement myAccount;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/div/span")
    protected WebElement pinkDropItemQuickView;

    @FindBy(xpath = "//*[@id=\"rev_slider_4_1\"]/ul/li/div[6]/div/div")
    protected WebElement shopNowLink;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/" +
            "div[2]/div[1]/div/div[1]/div/div[2]/div/a")
    protected WebElement wishListDropItem;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/" +
            "div[2]/div[1]/div/div[1]/a")
    protected WebElement pinkDropItem;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/" +
            "div[2]/div[1]/div/div[1]/div/div[1]")
    protected WebElement comparePinkDropItem;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/" +
            "div[2]/div[2]/div/div[1]/div/div[1]/a")
    protected WebElement comparePlayBoyItem;

    @FindBy(linkText = "My Wishlist")
    protected WebElement wishList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void dismissNoticeMessage() {
        waitForVisibility(noticeMessage);

        if (noticeMessage.isDisplayed()) {
            dismissLink.click();

        } else {
            logger.info("Notice message is not displayed.");
        }
    }

    public void clickMyAccountLink() {
        waitForVisibility(myAccount);
            myAccount.click();
    }

    public boolean isHomePageLoaded(String expectedTitle){
        wait.withTimeout(Duration.ofSeconds(10));
            return driver.getTitle().equalsIgnoreCase(expectedTitle);

    }

    public boolean clickShopNowLink(){
        waitForVisibility(shopNowLink);
            shopNowLink.isDisplayed();
                return false;
    }

    public void performSearch(String searchTerm){
        waitForVisibility(searchIcon);
            searchIcon.click();
                driver.switchTo().activeElement().sendKeys(searchTerm);
                    driver.switchTo().activeElement().sendKeys(Keys.ENTER);

    }

    public void clickToQuickViewPinkDropItem(){
         scrollToElement(new Point(1, 1000));

         Actions actions = new Actions(driver);
            actions.moveToElement(pinkDropItemQuickView).perform();
                waitForVisibility(pinkDropItemQuickView);
                    pinkDropItemQuickView.click();

    }

    public void addToWishListPinkDropItem(){
        scrollToElement(new Point(1, 1200));

        Actions actions = new Actions(driver);
            actions.moveToElement(wishListDropItem).perform();
                waitForVisibility(wishListDropItem);
                    wishListDropItem.click();
    }

    public void clickPinkDropItem(){
        scrollToElement(new Point(0, 1000));
            open("product/pink-drop-shoulder-oversized-t-shirt/");

    }

    public void clickToWishList(){
        wishList.click();
    }

    public void clickToCompareIconPinkDropItem(){
        scrollToElement(new Point(1, 1200));

        Actions actions = new Actions(driver);
            actions.moveToElement(comparePinkDropItem).perform();
                waitForVisibility(comparePinkDropItem);
                    comparePinkDropItem.click();
    }

    public void clickToCompareIconPlayboyItem(){
        scrollToElement(new Point(1, 1200));

        Actions actions = new Actions(driver);
            actions.moveToElement(comparePlayBoyItem).perform();
                waitForVisibility(comparePlayBoyItem);
                    comparePlayBoyItem.click();
    }

    public void clickToSelectOptions(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement selectOptions = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".noo-quick-link")));

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", selectOptions);

    }

}
