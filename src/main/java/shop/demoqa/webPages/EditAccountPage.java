package shop.demoqa.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditAccountPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"account_display_name\"]")
    protected WebElement displayNameField;

    @FindBy(css = ".button[name='save_account_details']")
    protected WebElement saveAccountButton;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div[1]")
    protected WebElement successMessage;

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public void updateDisplayName(String displayName){
        waitForVisibility(displayNameField);
        displayNameField.clear();
            displayNameField.sendKeys(displayName);
                saveAccountButton.click();
    }

    public boolean isAlertDisplayed(){
        waitForVisibility(successMessage);
            return successMessage.isDisplayed();
    }

    public String getSuccessMessageText(){
        waitForVisibility(successMessage);
            return successMessage.getText().trim();
    }
}
