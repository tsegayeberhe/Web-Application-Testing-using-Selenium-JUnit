package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    private By addRemoveBtn = By.cssSelector("button.btn_inventory");
    private By productTitle = By.cssSelector("div.inventory_details_name");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).getText();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addRemoveBtn)).click();
    }

    public String getAddRemoveButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addRemoveBtn)).getText();
    }
}
