package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class ProductsPage {
    private WebDriver driver;

    @FindBy(css = ".inventory_item:first-of-type button") 
    private WebElement firstAddToCartButton;

    @FindBy(css = ".shopping_cart_link") 
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstItemToCart() {
        firstAddToCartButton.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}
