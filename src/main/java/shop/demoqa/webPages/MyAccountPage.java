package shop.demoqa.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/nav/ul/li[5]/a")
    protected WebElement accountDetailsLink;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/section/div/div/h1")
    protected WebElement myAccountTitle;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/nav/ul/li[2]/a")
    protected WebElement ordersLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickToAccountDetails() {
        waitForVisibility(accountDetailsLink);
            accountDetailsLink.click();
    }

    public boolean isMyAccountTitleDisplayed(){
        waitForVisibility(myAccountTitle);
            return myAccountTitle.isDisplayed();
    }

    public void clickToOrdersLink(){
        waitForVisibility(ordersLink);
            ordersLink.click();
    }
}
