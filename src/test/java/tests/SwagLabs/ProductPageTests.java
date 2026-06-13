package tests.SwagLabs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.*;

public class ProductPageTests extends BaseTest {

    private final String productName = "Sauce Labs Backpack";

    @BeforeEach
    public void login() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
    }

    @Test
    public void addToCartProductPage() {
        HomePage home = new HomePage(driver);
        home.goToProduct(productName);

        ProductPage p = new ProductPage(driver);
        String before = p.getAddRemoveButtonText();
        p.clickAddToCart();
        String after = p.getAddRemoveButtonText();
        assertNotEquals(before, after, "Button text should change after adding to cart");
    }

    @Test
    public void removeFromCartProductPage() {
        HomePage home = new HomePage(driver);
        home.goToProduct(productName);

        ProductPage p = new ProductPage(driver);
        // ensure added
        p.clickAddToCart();
        String afterAdd = p.getAddRemoveButtonText();
        // now remove
        p.clickAddToCart();
        String afterRemove = p.getAddRemoveButtonText();
        assertNotEquals(afterAdd, afterRemove, "Button text should change after removing from cart");
    }
}
