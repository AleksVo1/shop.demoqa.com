package shop.demoqa.webPages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PinkDropItemPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"product-1497\"]/div[1]/div[2]/h1")
    protected WebElement pinkDropPageTitle;

    @FindBy(xpath = "//*[@id=\"pa_color\"]")
    protected WebElement pinkDropPageColor;

    @FindBy(xpath = "//*[@id=\"pa_size\"]")
    protected WebElement pinkDropPageSize;

    @FindBy(xpath = "//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")
    protected WebElement pinkDropPageAddToCartButton;

    @FindBy(css = ".noo-cart-simple .cart-item")
    protected WebElement pinkDropPageCartIcon;

    public PinkDropItemPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPinkDropPageTitleDisplayed(){
        waitForVisibility(pinkDropPageTitle);
            return pinkDropPageTitle.isDisplayed();
    }

    public void selectPinkDropPageColor() {
        Select select = new Select(pinkDropPageColor);
            select.selectByValue("pink");
    }

    public void selectPinkDropPageSize(){
        Select select1 = new Select(pinkDropPageSize);
            select1.selectByValue("36");
    }

    public void clickPinkDropPageAddToCartButton(){

        if (pinkDropPageAddToCartButton.isEnabled()){
            pinkDropPageAddToCartButton.click();
        }
        else {
            logger.error("Add to cart button is not enabled");
        }
    }

    public void clickToPinkDropPageCartIcon(){
        scrollToElement(new Point(0, 0));
            waitForVisibility(pinkDropPageCartIcon);
                pinkDropPageCartIcon.click();
    }
}
