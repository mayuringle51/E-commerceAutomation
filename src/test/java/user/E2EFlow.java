package user;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class E2EFlow {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            ;
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            Properties props = new Properties();
            props.load(new FileInputStream("src/test/resources/testdata/user.properties"));
            
            // ✅ Test Execution
            driver.get("https://www.saucedemo.com/");
            
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(props.getProperty("username"), props.getProperty("password"));
            
            ProductsPage productsPage = new ProductsPage(driver);
            productsPage.addFirstItemToCart();
            productsPage.goToCart();
            
            CartPage cartPage = new CartPage(driver);
            assert cartPage.isItemPresent() : "❌ Item not added to cart.";
            
            cartPage.clickCheckout();
            
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            checkoutPage.fillInformation(props.getProperty("firstname"), 
                                          props.getProperty("lastname"), 
                                          props.getProperty("postalcode"));
            checkoutPage.clickFinish();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(d -> checkoutPage.getConfirmationText().contains("Thank you"));
            
            assert checkoutPage.getConfirmationText().contains("Thank you") : "❌ Final confirmation failed.";
            
            System.out.println("✅ Test Passed: End-to-end order flow succeeded!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
