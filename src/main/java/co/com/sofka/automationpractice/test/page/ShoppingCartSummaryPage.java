package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

    @FindBy(id = "total_price")
    WebElement totalPrice;

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public ShoppingCartSummaryPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
