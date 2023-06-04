package shop.demoqa.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"noo-site\"]/section/div/div/h1")
    protected WebElement checkoutTitle;

    @FindBy(xpath = "//*[@id=\"billing_country\"]")
    protected WebElement countrySelector;

    @FindBy(xpath = "//*[@id=\"billing_address_1\"]")
    protected WebElement streetAddressField;

    @FindBy(xpath = "//*[@id=\"billing_city\"]")
    protected WebElement cityField;

    @FindBy(xpath = "//*[@id=\"billing_state\"]")
    protected WebElement stateSelector;

    @FindBy(xpath = "//*[@id=\"billing_postcode\"]")
    protected WebElement postCodeField;

    @FindBy(xpath = "//*[@id=\"billing_phone\"]")
    protected WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id=\"billing_email\"]")
    protected WebElement emailField;

    @FindBy(xpath = "//*[@id=\"terms\"]")
    protected WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"place_order\"]")
    protected WebElement placeOrderButton;

    @FindBy(xpath = "//*[@id=\"post-7\"]/div/div/div/p[1]")
    protected WebElement thankYouMessage;

    @FindBy(css = ".woocommerce-customer-details h2")
    protected WebElement billingAddress;

    @FindBy(css = ".woocommerce-order-details h2")
    protected WebElement orderDetails;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
    protected WebElement myAccountLink;

    @FindBy(id = "order_review_heading")
    protected WebElement orderDetailsItem;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckoutTitleDisplayed(){
        waitForVisibility(checkoutTitle);
            return checkoutTitle.isDisplayed();

    }

    public void fillOutBillingDetails(String country, String address, String city, String state,
                                      String postCode, String phone, String email) {
        Select select = new Select(countrySelector);
            select.selectByVisibleText(country);
                waitForVisibility(countrySelector);

        streetAddressField.clear();
            streetAddressField.sendKeys(address);

            cityField.clear();
            cityField.sendKeys(city);

        Select select1 = new Select(stateSelector);
            select1.selectByVisibleText(state);
                waitForVisibility(stateSelector);

        postCodeField.clear();
            postCodeField.sendKeys(postCode);

        phoneNumberField.clear();
            phoneNumberField.sendKeys(phone);

        emailField.clear();
            emailField.sendKeys(email);

    }

    public void selectCheckBox(){
        checkBox.click();
    }

    public void clickToPlaceOrderButton(){
        placeOrderButton.click();
    }

    public boolean isThankYouMassageDisplayed(){
        waitForVisibility(thankYouMessage);
            return thankYouMessage.isDisplayed();
    }

    public void clickToMyAccountLinkCheckoutPage(){
        waitForVisibility(myAccountLink);
            myAccountLink.click();
    }

    public boolean isOrderDetailsDisplayed(){
        waitForVisibility(orderDetails);
            return orderDetails.isDisplayed();
    }

    public boolean isBillingAddressDisplayed(){
        waitForVisibility(billingAddress);
            return billingAddress.isDisplayed();
    }

    public String getOrderNumber() {
        try {
            WebElement orderNumberElement = driver.findElement(By
                    .cssSelector(".woocommerce ul.order_details li[class='order'] strong"));
            return orderNumberElement.getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isOrderDetailsItemDisplayed(){
        waitForVisibility(orderDetailsItem);
            return orderDetailsItem.isDisplayed();
    }

}
