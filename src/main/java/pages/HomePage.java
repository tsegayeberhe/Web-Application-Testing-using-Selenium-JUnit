package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    private By inventoryItems = By.cssSelector("div.inventory_item");
    private By cartBadge = By.cssSelector("a.shopping_cart_link .shopping_cart_badge");
    private By sortSelect = By.cssSelector("select.product_sort_container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            WebElement title = item.findElement(By.cssSelector("div.inventory_item_name"));
            if (title.getText().trim().equals(productName)) {
                title.click();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    public void addToCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            WebElement title = item.findElement(By.cssSelector("div.inventory_item_name"));
            if (title.getText().trim().equals(productName)) {
                WebElement btn = item.findElement(By.cssSelector("button.btn_inventory"));
                wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
                return;
            }
        }
        throw new RuntimeException("Product not found to add: " + productName);
    }

    public void removeFromCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItems));
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            WebElement title = item.findElement(By.cssSelector("div.inventory_item_name"));
            if (title.getText().trim().equals(productName)) {
                WebElement btn = item.findElement(By.cssSelector("button.btn_inventory"));
                wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
                return;
            }
        }
        throw new RuntimeException("Product not found to remove: " + productName);
    }

    public int getCartCount() {
        try {
            String text = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
            return Integer.parseInt(text);
        } catch (Exception e) {
            return 0;
        }
    }

    public void applyFilter(String value) {
        WebElement sel = wait.until(ExpectedConditions.elementToBeClickable(sortSelect));
        sel.click();
        WebElement option = sel.findElement(By.cssSelector("option[value='" + value + "']"));
        option.click();
        wait.until(ExpectedConditions.stalenessOf(option));
    }
}
