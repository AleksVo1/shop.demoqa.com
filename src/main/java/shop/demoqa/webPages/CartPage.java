package shop.demoqa.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"noo-site\"]/section/div/div/h1")
    protected WebElement cartTitle;

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[2]/a")
    protected WebElement pinkDropTitleCart;

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")
    protected WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartTitleDisplayed(){
        waitForVisibility(cartTitle);
            return cartTitle.isDisplayed();

    }

    public boolean isPinkDropTitleCartDisplayed(){
        waitForVisibility(pinkDropTitleCart);
            return pinkDropTitleCart.isDisplayed();

    }

    public void clickToCheckoutButton(){
        checkoutButton.click();
    }

}
