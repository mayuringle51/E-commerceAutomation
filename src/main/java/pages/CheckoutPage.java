package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class CheckoutPage {
    private WebDriver driver;

    @FindBy(id = "first-name") private WebElement firstNameInput;
    @FindBy(id = "last-name") private WebElement lastNameInput;
    @FindBy(id = "postal-code") private WebElement postalCodeInput;
    @FindBy(id = "continue") private WebElement continueButton;

    @FindBy(id = "finish") private WebElement finishButton;

    @FindBy(css = ".complete-header") private WebElement confirmationHeader;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getConfirmationText() {
        return confirmationHeader.getText();
    }
}
