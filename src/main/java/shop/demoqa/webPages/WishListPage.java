package shop.demoqa.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(css = ".page-title")
    protected WebElement wishListTitle;

    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-1497\"]/td[3]")
    protected WebElement pinkDropTitleWishList;

    public WishListPage(WebDriver driver) {

        super(driver);
    }

    public boolean isWishListTitleDisplayed(){
        waitForVisibility(wishListTitle);
            return wishListTitle.isDisplayed();

    }

    public boolean isPinkDropTitleWishListDisplayed(){
        waitForVisibility(pinkDropTitleWishList);
            return pinkDropTitleWishList.isDisplayed();

    }
}
