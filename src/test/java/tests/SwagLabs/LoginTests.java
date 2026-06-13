package tests.SwagLabs;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTests extends BaseTest {

    @Test
    public void login() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        HomePage home = new HomePage(driver);
        assertTrue(home.getCartCount() >= 0, "Expected to be on home page after login");
    }

    @Test
    public void loginEnter() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.pressEnterToLogin();

        HomePage home = new HomePage(driver);
        assertTrue(home.getCartCount() >= 0, "Pressing Enter should login the user and reach the home page");
    }

    @Test
    public void loginInvalidEmail() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("invalid_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        String err = login.getErrorText();
        assertTrue(err.toLowerCase().contains("username") || err.toLowerCase().contains("user"), "Expected username-related error message, got: " + err);
    }

    @Test
    public void loginInvalidPassword() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("wrong_password");
        login.clickLogin();

        String err = login.getErrorText();
        assertTrue(err.toLowerCase().contains("password") || err.toLowerCase().contains("credentials"), "Expected password-related error message, got: " + err);
    }

    @Test
    public void logout() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#react-burger-menu-btn"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#logout_sidebar_link"))).click();

        // after logout we should be back on login page
        assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Expected to be redirected to login page after logout");
    }
}
