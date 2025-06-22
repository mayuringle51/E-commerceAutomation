package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name") private WebElement usernameInput;
    @FindBy(id = "password") private WebElement passwordInput;
    @FindBy(id = "login-button") private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
