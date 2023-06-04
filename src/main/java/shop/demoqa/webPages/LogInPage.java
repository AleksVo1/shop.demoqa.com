package shop.demoqa.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    @FindBy(id = "username")
    protected WebElement usernameField;

    @FindBy(id = "password")
    protected WebElement passwordField;

    @FindBy(css = ".button[name='login']")
    protected WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"reg_username\"]")
    protected WebElement usernameFieldCreate;

    @FindBy(xpath = "//*[@id=\"reg_email\"]")
    protected WebElement emailFieldCreate;

    @FindBy(xpath = "//*[@id=\"reg_password\"]")
    protected WebElement passwordFieldCreate;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")
    protected WebElement registerButton;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[2]/div/div/div/div/a")
    protected WebElement logo;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/p[1]/a")
    protected WebElement logOutButton;

    @FindBy(css = ".woocommerce-notices-wrapper")
    protected WebElement helloMessage;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        usernameField.sendKeys(username);
            passwordField.sendKeys(password);
                loginButton.click();
    }

    public void clickLogo(){
        waitForVisibility(logo);
            logo.click();
    }

    public void createAccount(String username, String email, String password) {
        waitForVisibility(registerButton);
        usernameFieldCreate.sendKeys(username);
            emailFieldCreate.sendKeys(email);
                passwordFieldCreate.sendKeys(password);
                    waitForVisibility(registerButton);
                        registerButton.click();
    }

    public void clickToLogOutButton(){
        waitForVisibility(logOutButton);
            logOutButton.click();
    }

    public boolean isHelloMessageDisplayed(){
        waitForVisibility(helloMessage);
            return helloMessage.isDisplayed();
    }

}
