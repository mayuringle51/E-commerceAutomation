package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class CartPage {
    private WebDriver driver;

    @FindBy(css = ".cart_item") 
    private WebElement cartItem;

    @FindBy(id = "checkout") 
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isItemPresent() {
        return cartItem.isDisplayed();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
