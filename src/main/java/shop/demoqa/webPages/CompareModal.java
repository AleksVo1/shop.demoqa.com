package shop.demoqa.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompareModal extends BasePage{

    @FindBy(xpath = "//td[normalize-space()='No products added in the compare table.']")
    protected WebElement compareModalNoProductsMessage;

    @FindBy(xpath = "//td[@class='odd product_1497']//img[@class='attachment-yith-woocompare-image size-yith-woocompare-image']")
    protected WebElement elementToInvisible;

    @FindBy(tagName = "h1")
    protected WebElement compareProductsTitle;

    @FindBy(tagName = "h1")
    protected WebElement compareProductsTitle2;

    @FindBy(xpath = "//td[normalize-space()='pink drop shoulder oversized t shirt']")
    protected WebElement compareProductsFirstTitle;

    @FindBy(xpath = "//td[contains(text(),'playboy x missguided plus size grey lips print fro')]")
    protected WebElement compareProductsSecondTitle;


    public CompareModal(WebDriver driver) {
        super(driver);
    }

    public void activateFrame(){
        By cboxLoadedContentSelector = By.id("cboxLoadedContent");

        WebElement modalWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(cboxLoadedContentSelector));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(modalWindow.findElement(By.tagName("iframe"))));
    }

    public boolean isCompareProductsTitleDisplayed() {
        activateFrame();

        String titleText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;"
                , compareProductsTitle);
        return titleText.equalsIgnoreCase("Compare products");

    }

    public boolean isCompareProductsTitleDisplayed2() {
        activateFrame();

        String titleText2 = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;"
                , compareProductsTitle2);
        return titleText2.equalsIgnoreCase("Compare products");

    }

    public void clickToCloseCompareModal(){
        driver.switchTo().defaultContent();

        WebElement compareModalClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboxClose")));

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", compareModalClose);
    }
    public boolean isFirstItemTitleDisplayed(){
        String firstItemTitle = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;"
                , compareProductsFirstTitle);

        return firstItemTitle.equalsIgnoreCase("pink drop shoulder oversized t shirt");
    }

    public boolean isSecondItemTitleDisplayed(){
        String secondItemTitle = (String) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].innerText;"
                    , compareProductsSecondTitle);

        return secondItemTitle
                .equalsIgnoreCase("playboy x missguided plus size grey lips print front cropped t shirt");

    }

    public void clickToRemoveFirstItem(){
        WebElement compareModalRemoveFirst = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By
                        .xpath("//tr[@class='remove odd']//td[@class='even product_1491']//a[1]")));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", compareModalRemoveFirst);
            compareModalRemoveFirst.click();

        wait.until(ExpectedConditions.stalenessOf(compareModalRemoveFirst));

    }

    public void clickToRemoveSecondItem(){
        WebElement compareModalRemoveSecond = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//tr[@class='remove odd']//a[1]")));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", compareModalRemoveSecond);
            compareModalRemoveSecond.click();

    }

    public String noProductsDisplayedMessage() {
        waitForVisibility(compareModalNoProductsMessage);

        return compareModalNoProductsMessage.getText();
    }

}
