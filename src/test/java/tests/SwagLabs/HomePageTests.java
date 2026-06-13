package tests.SwagLabs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTests extends BaseTest {

    private final String productName = "Sauce Labs Backpack";

    @BeforeEach
    public void login() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();
    }

    @Test
    public void goToProductPage() {
        HomePage home = new HomePage(driver);
        home.goToProduct(productName);

        // verify we navigated to product by checking title on product page via pages.ProductPage
        pages.ProductPage p = new pages.ProductPage(driver);
        assertEquals(productName, p.getTitle(), "Clicking the product title should open product details page");
    }

    @Test
    public void addToCart() {
        HomePage home = new HomePage(driver);
        int before = home.getCartCount();
        home.addToCart(productName);
        int after = home.getCartCount();
        assertEquals(before + 1, after, "Adding a product should increment cart badge by 1");
    }

    @Test
    public void removeFromCart() {
        HomePage home = new HomePage(driver);
        // ensure item is added first
        home.addToCart(productName);
        int afterAdd = home.getCartCount();
        assertTrue(afterAdd >= 1, "Expected at least one item in cart after adding");

        home.removeFromCart(productName);
        int afterRemove = home.getCartCount();
        assertTrue(afterRemove <= afterAdd - 1, "Removing should decrement the cart badge");
    }

    @Test
    public void applyFilter() {
        HomePage home = new HomePage(driver);
        // apply name A-Z
        home.applyFilter("az");
        // basic verification: the page should still show items; checking first item exists
        assertTrue(driver.getPageSource().contains("inventory_item"), "Applying filter should leave inventory visible");
    }
}
